package net.sessu.WRTracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.io.FileWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {
	static List<Song> songlist;
	static List<Score> scorelist;
	static List<Score> prunedScorelist;
	static List<Player> playerlist;

	public static void main(String[] args) {
		playerlist = new ArrayList<Player>();

		songlist = makeSonglist();
		System.out.println(songlist.get(songlist.size() - 1).toJsString());

		scorelist = new ArrayList<Score>();
		getTopScores();

		System.out.println(scorelist.size() + " scores");
		List<Score> prunedScorelist = prune_scores();
		System.out.println(
				"Pruned to " + prunedScorelist.size() + " scores... " + (scorelist.size() - prunedScorelist.size()));

		update_player_totals(prunedScorelist);

		songlist_to_json(songlist);
		scorelist_to_json(prunedScorelist);

		System.out.println(playerlist.size() + " players");
		prune_playerlist();
		System.out.println(playerlist.size() + " players");
		
		playerlist_to_json(playerlist);
	}

	public static void prune_playerlist() {
		for (int i = 0; i < playerlist.size(); i++) {
			double size = playerlist.get(i).getWeighted_score();
			if (size == 0.0) {
				playerlist.remove(i);
			}
		}
		System.out.println(playerlist.size());
	}

	public static void update_player_totals(List<Score> prunedScorelist) {
		for (Score score : prunedScorelist) {
			int id = score.getSong_id();
			int level = score.getLevel();
			final int ddrcode = score.getDdrcode();
			int ties = 0;

			// Find player within player list
			int player_index = IntStream.range(0, playerlist.size())
					.filter(i -> playerlist.get(i).getDdrcode() == ddrcode).findFirst().orElse(-1);
			if (player_index > -1) {
				Player this_player = playerlist.get(player_index);

				switch (level) {
				case 0:
					ties = songlist.get(id).getBeg_c();
					if (ties == 1) {
						this_player.setWeighted_score(this_player.getWeighted_score() + 1);
						this_player.setBeg_s(this_player.getBeg_s() + 1);
						this_player.setTotal_u(this_player.getTotal_u() + 1);
						this_player.setBeg_u(this_player.getBeg_u() + 1);
					} else if (ties > 1) {
						double points = 1.0 / ties;
						this_player.setWeighted_score(this_player.getWeighted_score() + points);
						this_player.setBeg_s(this_player.getBeg_s() + points);
						this_player.setTotal_t(this_player.getTotal_t() + 1);
						this_player.setBeg_t(this_player.getBeg_t() + 1);
					}
					break;
				case 1:
					ties = songlist.get(id).getBsp_c();
					if (ties == 1) {
						this_player.setWeighted_score(this_player.getWeighted_score() + 1);
						this_player.setBsp_s(this_player.getBsp_s() + 1);
						this_player.setTotal_u(this_player.getTotal_u() + 1);
						this_player.setBsp_u(this_player.getBsp_u() + 1);
					} else if (ties > 1) {
						double points = 1.0 / ties;
						this_player.setWeighted_score(this_player.getWeighted_score() + points);
						this_player.setBsp_s(this_player.getBsp_s() + points);
						this_player.setTotal_t(this_player.getTotal_t() + 1);
						this_player.setBsp_t(this_player.getBsp_t() + 1);
					}
					break;
				case 2:
					ties = songlist.get(id).getDsp_c();
					if (ties == 1) {
						this_player.setWeighted_score(this_player.getWeighted_score() + 1);
						this_player.setDsp_s(this_player.getDsp_s() + 1);
						this_player.setTotal_u(this_player.getTotal_u() + 1);
						this_player.setDsp_u(this_player.getDsp_u() + 1);
					} else if (ties > 1) {
						double points = 1.0 / ties;
						this_player.setWeighted_score(this_player.getWeighted_score() + points);
						this_player.setDsp_s(this_player.getDsp_s() + points);
						this_player.setTotal_t(this_player.getTotal_t() + 1);
						this_player.setDsp_t(this_player.getDsp_t() + 1);
					}
					break;
				case 3:
					ties = songlist.get(id).getEsp_c();
					if (ties == 1) {
						this_player.setWeighted_score(this_player.getWeighted_score() + 1);
						this_player.setEsp_s(this_player.getEsp_s() + 1);
						this_player.setTotal_u(this_player.getTotal_u() + 1);
						this_player.setEsp_u(this_player.getEsp_u() + 1);
					} else if (ties > 1) {
						double points = 1.0 / ties;
						this_player.setWeighted_score(this_player.getWeighted_score() + points);
						this_player.setEsp_s(this_player.getEsp_s() + points);
						this_player.setTotal_t(this_player.getTotal_t() + 1);
						this_player.setEsp_t(this_player.getEsp_t() + 1);
					}
					break;
				case 4:
					ties = songlist.get(id).getCsp_c();
					if (ties == 1) {
						this_player.setWeighted_score(this_player.getWeighted_score() + 1);
						this_player.setCsp_s(this_player.getCsp_s() + 1);
						this_player.setTotal_u(this_player.getTotal_u() + 1);
						this_player.setCsp_u(this_player.getCsp_u() + 1);
					} else if (ties > 1) {
						double points = 1.0 / ties;
						this_player.setWeighted_score(this_player.getWeighted_score() + points);
						this_player.setCsp_s(this_player.getCsp_s() + points);
						this_player.setTotal_t(this_player.getTotal_t() + 1);
						this_player.setCsp_t(this_player.getCsp_t() + 1);
					}
					break;
				case 5:
					ties = songlist.get(id).getBdp_c();
					if (ties == 1) {
						this_player.setWeighted_score(this_player.getWeighted_score() + 1);
						this_player.setBdp_s(this_player.getBdp_s() + 1);
						this_player.setTotal_u(this_player.getTotal_u() + 1);
						this_player.setBdp_u(this_player.getBdp_u() + 1);
					} else if (ties > 1) {
						double points = 1.0 / ties;
						this_player.setWeighted_score(this_player.getWeighted_score() + points);
						this_player.setBdp_s(this_player.getBdp_s() + points);
						this_player.setTotal_t(this_player.getTotal_t() + 1);
						this_player.setBdp_t(this_player.getBdp_t() + 1);
					}
					break;
				case 6:
					ties = songlist.get(id).getDdp_c();
					if (ties == 1) {
						this_player.setWeighted_score(this_player.getWeighted_score() + 1);
						this_player.setDdp_s(this_player.getDdp_s() + 1);
						this_player.setTotal_u(this_player.getTotal_u() + 1);
						this_player.setDdp_u(this_player.getDdp_u() + 1);
					} else if (ties > 1) {
						double points = 1.0 / ties;
						this_player.setWeighted_score(this_player.getWeighted_score() + points);
						this_player.setDdp_s(this_player.getDdp_s() + points);
						this_player.setTotal_t(this_player.getTotal_t() + 1);
						this_player.setDdp_t(this_player.getDdp_t() + 1);
					}
					break;
				case 7:
					ties = songlist.get(id).getEdp_c();
					if (ties == 1) {
						this_player.setWeighted_score(this_player.getWeighted_score() + 1);
						this_player.setEdp_s(this_player.getEdp_s() + 1);
						this_player.setTotal_u(this_player.getTotal_u() + 1);
						this_player.setEdp_u(this_player.getEdp_u() + 1);
					} else if (ties > 1) {
						double points = 1.0 / ties;
						this_player.setWeighted_score(this_player.getWeighted_score() + points);
						this_player.setEdp_s(this_player.getEdp_s() + points);
						this_player.setTotal_t(this_player.getTotal_t() + 1);
						this_player.setEdp_t(this_player.getEdp_t() + 1);
					}
					break;
				case 8:
					ties = songlist.get(id).getCdp_c();
					if (ties == 1) {
						this_player.setWeighted_score(this_player.getWeighted_score() + 1);
						this_player.setCdp_s(this_player.getCdp_s() + 1);
						this_player.setTotal_u(this_player.getTotal_u() + 1);
						this_player.setCdp_u(this_player.getCdp_u() + 1);
					} else if (ties > 1) {
						double points = 1.0 / ties;
						this_player.setWeighted_score(this_player.getWeighted_score() + points);
						this_player.setCdp_s(this_player.getCdp_s() + points);
						this_player.setTotal_t(this_player.getTotal_t() + 1);
						this_player.setCdp_t(this_player.getCdp_t() + 1);
					}
					break;
				}

				// System.out.println(player_index + " " + this_player);
				playerlist.set(player_index, this_player);
			}

			// System.out.println(playerlist.get(player_index));
		}
	}

	public static List<Score> prune_scores() {
		List<Score> tempScorelist = new ArrayList<Score>();

		for (Score score : scorelist) {
			int id = score.getSong_id();
			int level = score.getLevel();
			switch (level) {
			case 0:
				if (songlist.get(id).getBeg_s() == score.getScore()) {
					tempScorelist.add(score);
					songlist.get(id).setBeg_c(songlist.get(id).getBeg_c() + 1);
				}
				break;
			case 1:
				if (songlist.get(id).getBsp_s() == score.getScore()) {
					tempScorelist.add(score);
					songlist.get(id).setBsp_c(songlist.get(id).getBsp_c() + 1);
				}
				break;
			case 2:
				if (songlist.get(id).getDsp_s() == score.getScore()) {
					tempScorelist.add(score);
					songlist.get(id).setDsp_c(songlist.get(id).getDsp_c() + 1);
				}
				break;
			case 3:
				if (songlist.get(id).getEsp_s() == score.getScore()) {
					tempScorelist.add(score);
					songlist.get(id).setEsp_c(songlist.get(id).getEsp_c() + 1);
				}
				break;
			case 4:
				if (songlist.get(id).getCsp_s() == score.getScore()) {
					tempScorelist.add(score);
					songlist.get(id).setCsp_c(songlist.get(id).getCsp_c() + 1);
				}
				break;
			case 5:
				if (songlist.get(id).getBdp_s() == score.getScore()) {
					tempScorelist.add(score);
					songlist.get(id).setBdp_c(songlist.get(id).getBdp_c() + 1);
				}
				break;
			case 6:
				if (songlist.get(id).getDdp_s() == score.getScore()) {
					tempScorelist.add(score);
					songlist.get(id).setDdp_c(songlist.get(id).getDdp_c() + 1);
				}
				break;
			case 7:
				if (songlist.get(id).getEdp_s() == score.getScore()) {
					tempScorelist.add(score);
					songlist.get(id).setEdp_c(songlist.get(id).getEdp_c() + 1);
				}
				break;
			case 8:
				if (songlist.get(id).getCdp_s() == score.getScore()) {
					tempScorelist.add(score);
					songlist.get(id).setCdp_c(songlist.get(id).getCdp_c() + 1);
				}
				break;
			}
		}

		return tempScorelist;

	}

	public static void songlist_to_json(List<Song> songlist) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {
			File file = new File("songs.json");
			file.createNewFile();
			FileWriter writer = new FileWriter(file);

			int pk = 0;
			writer.write("[");
			for (Song song : songlist) {
				writer.write("\n{");
				writer.write("\n\"model\": \"trackerapp.song\",");
				writer.write("\n\"pk\": " + pk + ",");
				writer.write("\n\"fields\": ");
				writer.write(gson.toJson(song));
				writer.write("\n}");
				if (pk + 1 != songlist.size()) {
					writer.write(",");
				}
				pk++;
			}
			writer.write("\n]");

			writer.flush();
			writer.close();
			System.out.println("Wrote songs");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void playerlist_to_json(List<Player> playerlist) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {
			File file = new File("players.json");
			file.createNewFile();
			FileWriter writer = new FileWriter(file);

			int pk = 1;
			writer.write("[");
			for (Player p : playerlist) {
				if (p.getWeighted_score() > 0.0) {
					writer.write("\n{");
					writer.write("\n\"model\": \"trackerapp.player\",");
					writer.write("\n\"pk\": " + pk + ",");
					writer.write("\n\"fields\": ");
					writer.write(gson.toJson(p));
					writer.write("\n}");
					if (pk != scorelist.size()) {
						writer.write(",");
					}
				}
				pk++;
			}
			writer.write("\n]");

			writer.flush();
			writer.close();
			System.out.println("Wrote players");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void songlist_to_js(List<Song> songlist) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {
			File file = new File("song-names.js");
			file.createNewFile();
			FileWriter writer = new FileWriter(file);

			int pk = 1;
			writer.write("var songData = [\n");
			for (Song song : songlist) {
				writer.write(gson.toJson(song));
				if (pk != songlist.size()) {
					writer.write(",\n");
				}
				pk++;
			}
			writer.write("\n];");

			writer.flush();
			writer.close();
			System.out.println("Wrote songs");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void scorelist_to_json(List<Score> scorelist) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {
			File file = new File("scores.json");
			file.createNewFile();
			FileWriter writer = new FileWriter(file);

			int pk = 1;
			writer.write("[");
			for (Score score : scorelist) {
				writer.write("\n{");
				writer.write("\n\"model\": \"trackerapp.score\",");
				writer.write("\n\"pk\": " + pk + ",");
				writer.write("\n\"fields\": ");
				writer.write(gson.toJson(score));
				writer.write("\n}");
				if (pk != scorelist.size()) {
					writer.write(",");
				}
				pk++;
			}
			writer.write("\n]");

			writer.flush();
			writer.close();
			System.out.println("Wrote scores");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Song> makeSonglist() {
		List<Song> songlist = new ArrayList<Song>();

		try {
			URL music_list = new URL("http://skillattack.com/sa4/data/master_music.txt");

			// Set up the connection
			URLConnection yc = music_list.openConnection();
			yc.setRequestProperty("User-Agent", "Mozilla/5.0");
			Charset charset = Charset.forName("Shift_JIS");

			// Start connection
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), charset));
			String inputLine;

			// Run through .txt file and get all songs
			while ((inputLine = in.readLine()) != null) {
				String[] field = inputLine.split("\\t");
				Song newSong = new Song(Integer.valueOf(field[0]));
				newSong.setKonami_id(field[1]);
				newSong.setBeg(Integer.valueOf(field[2]));
				newSong.setBsp(Integer.valueOf(field[3]));
				newSong.setDsp(Integer.valueOf(field[4]));
				newSong.setEsp(Integer.valueOf(field[5]));
				newSong.setCsp(Integer.valueOf(field[6]));
				newSong.setBdp(Integer.valueOf(field[7]));
				newSong.setDdp(Integer.valueOf(field[8]));
				newSong.setEdp(Integer.valueOf(field[9]));
				newSong.setCdp(Integer.valueOf(field[10]));
				newSong.setTitle(field[11]);
				newSong.setArtist(field[12]);
				// System.out.println(newSong.toString());
				songlist.add(newSong);
			}
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return songlist;
	}

	public static void getTopScores() {
		// Vars for sleep
		long lastPullTimeUnixMs = 0;
		final long PULL_THRESHOLD_SEC = 3;
		final int SONG_LIMIT = songlist.size();

		try {
			WebClient webClient = new WebClient(BrowserVersion.CHROME);

			// For loop (iterates through all songs in song list)
			// Currently capped at 10
			for (int sa4_index = 0; sa4_index < SONG_LIMIT; sa4_index++) {

				// Limits speed to 1 song per 3 seconds
				long nowUnixMs = System.currentTimeMillis();
				long timeSinceLastInMs = nowUnixMs - lastPullTimeUnixMs;

				if (timeSinceLastInMs < PULL_THRESHOLD_SEC * 1000) {
					try {
						Thread.sleep((PULL_THRESHOLD_SEC * 1000) - timeSinceLastInMs);
					} catch (Exception e) {
						System.out.println("Error sleeping: " + e.getLocalizedMessage());
						e.printStackTrace();
					}
				}
				lastPullTimeUnixMs = System.currentTimeMillis();

				Song song = songlist.get(sa4_index); // Temporary song

				// Connect to designated song page
				HtmlPage myPage = webClient.getPage("http://skillattack.com/sa4/music.php?index=" + sa4_index);
				Document doc = Jsoup.parse(myPage.asXml());

				// Get table rows from the song page
				Element score_table = doc.selectFirst("table");
				Elements rows = score_table.select("tbody > tr");

				// Go row by row (each row represents a user)
				for (Element row : rows) {
					Elements cells = row.select("td"); // rank, name, single diffs (x5) double diffs (x4)

					int ddrcode = -1;
					if (cells.size() > 0) {

						// Find first link within row, strip it to get the DDR code
						Element link_element = cells.select("a").first();

						// Get player name and ddrcode
						String name = link_element.text();
						String link = link_element.attr("href");
						String ddrcode_string = link.substring(link.indexOf("=") + 1).strip();
						if (!ddrcode_string.contains("a")) {
							ddrcode = Integer.valueOf(ddrcode_string);
						}

						// Add player to list if not there already
						final int code_check = ddrcode;
						boolean in_list = playerlist.stream().filter(o -> o.getDdrcode() == code_check).findFirst()
								.isPresent();
						if (!in_list) {
							Player newplayer = new Player(ddrcode, name);
							// System.out.println(newplayer.getName());
							playerlist.add(newplayer);
						}

						// Remaining cells are scores for the associated DDR code.
						// Compares score to WR, if there is a match, adds the score to our arrayList
						// FIRST PASS: GET TOP SCORE ONLY
						for (int i = 2; i < cells.size(); i++) {
							String current_score_string = cells.get(i).text().replace(",", "");
							if (current_score_string.contains("0")) {
								int current_score = Integer.valueOf(current_score_string);
								switch (i) {

								// Singles
								case 2:
									if (current_score >= song.getBeg_s()) {
										song.setBeg_s(current_score);
										scorelist.add(new Score(sa4_index, i - 2, ddrcode, current_score));
									}
									break;
								case 3:
									if (current_score >= song.getBsp_s()) {
										song.setBsp_s(current_score);
										scorelist.add(new Score(sa4_index, i - 2, ddrcode, current_score));
									}
									break;
								case 4:
									if (current_score >= song.getDsp_s()) {
										song.setDsp_s(current_score);
										scorelist.add(new Score(sa4_index, i - 2, ddrcode, current_score));
									}
									break;
								case 5:
									if (current_score >= song.getEsp_s()) {
										song.setEsp_s(current_score);
										scorelist.add(new Score(sa4_index, i - 2, ddrcode, current_score));
									}
									break;
								case 6:
									if (current_score >= song.getCsp_s()) {
										song.setCsp_s(current_score);
										scorelist.add(new Score(sa4_index, i - 2, ddrcode, current_score));
									}
									break;
								// Doubles
								case 7:
									if (current_score >= song.getBdp_s()) {
										song.setBdp_s(current_score);
										scorelist.add(new Score(sa4_index, i - 2, ddrcode, current_score));
									}
									break;
								case 8:
									if (current_score >= song.getDdp_s()) {
										song.setDdp_s(current_score);
										scorelist.add(new Score(sa4_index, i - 2, ddrcode, current_score));
									}
									break;
								case 9:
									if (current_score >= song.getEdp_s()) {
										song.setEdp_s(current_score);
										scorelist.add(new Score(sa4_index, i - 2, ddrcode, current_score));
									}
									break;
								case 10:
									if (current_score >= song.getCdp_s()) {
										song.setCdp_s(current_score);
										scorelist.add(new Score(sa4_index, i - 2, ddrcode, current_score));
									}
									break;

								}
							}
						}
					}
				}
				songlist.set(sa4_index, song); // Updates given song in songlist ArrayList
				System.out.println(song.toString());
			}
			webClient.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

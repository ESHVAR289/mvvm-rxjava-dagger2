package com.einfoplanet.news;

import com.einfoplanet.news.data.model.Article;
import com.einfoplanet.news.data.model.NewsApiDO;
import com.einfoplanet.news.ui.list.NewsListAdapter;
import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DataValidationTest {
    private boolean isValidSourceName, isValidAuthor, isValidDescription, isValidUrlToImage;
    private Object objAuthor, objDescription, objUrlToImage;
    private String strSourceName;

    @Parameterized.Parameters
    public static Collection data() {
        List<Article> list = getDummyData();
        return Arrays.asList(new Object[][]{
                {true, list.get(0).source.name, true, list.get(0).author, true, list.get(0).description, true, list.get(0).urlToImage},
                {true, list.get(1).source.name, true, list.get(1).author, true, list.get(1).description, true, list.get(1).urlToImage},
                {true, list.get(2).source.name, true, list.get(2).author, true, list.get(2).description, true, list.get(2).urlToImage},
                {true, list.get(3).source.name, true, list.get(3).author, true, list.get(3).description, true, list.get(3).urlToImage},
                {true, list.get(4).source.name, true, list.get(4).author, true, list.get(4).description, true, list.get(4).urlToImage},
                {true, list.get(5).source.name, true, list.get(5).author, true, list.get(5).description, true, list.get(5).urlToImage},
                {true, list.get(6).source.name, true, list.get(6).author, true, list.get(6).description, true, list.get(6).urlToImage},
                {true, list.get(7).source.name, true, list.get(7).author, true, list.get(7).description, true, list.get(7).urlToImage},
                {true, list.get(8).source.name, true, list.get(8).author, true, list.get(8).description, true, list.get(8).urlToImage},
                {true, list.get(9).source.name, true, list.get(9).author, true, list.get(9).description, true, list.get(9).urlToImage},
                {true, list.get(10).source.name, true, list.get(10).author, true, list.get(10).description, true, list.get(10).urlToImage},
                {true, list.get(11).source.name, true, list.get(11).author, true, list.get(11).description, true, list.get(11).urlToImage},
                {true, list.get(12).source.name, true, list.get(12).author, true, list.get(12).description, true, list.get(12).urlToImage},
                {true, list.get(13).source.name, true, list.get(13).author, true, list.get(13).description, true, list.get(13).urlToImage},
                {true, list.get(14).source.name, true, list.get(14).author, true, list.get(14).description, true, list.get(14).urlToImage},
                {true, list.get(15).source.name, true, list.get(15).author, true, list.get(15).description, true, list.get(15).urlToImage},
                {true, list.get(16).source.name, true, list.get(16).author, true, list.get(16).description, true, list.get(16).urlToImage},
                {true, list.get(17).source.name, true, list.get(17).author, true, list.get(17).description, true, list.get(17).urlToImage},
                {true, list.get(18).source.name, true, list.get(18).author, true, list.get(18).description, true, list.get(18).urlToImage},
                {true, list.get(19).source.name, true, list.get(19).author, true, list.get(19).description, true, list.get(19).urlToImage},
        });
    }

    public DataValidationTest(boolean isValidSourceName,
                              String strSourceName,
                              boolean isValidAuthor,
                              Object objAuthor,
                              boolean isValidDescription,
                              Object objDescription,
                              boolean isValidUrlToImage,
                              Object objUrlToImage) {
        this.isValidSourceName = isValidSourceName;
        this.strSourceName = strSourceName;
        this.isValidAuthor = isValidAuthor;
        this.objAuthor = objAuthor;
        this.isValidDescription = isValidDescription;
        this.objDescription = objDescription;
        this.isValidUrlToImage = isValidUrlToImage;
        this.objUrlToImage = objUrlToImage;
    }

    @Test
    public void checkValidAuthorData() throws Exception {
        assertEquals(isValidAuthor, NewsListAdapter.isValidAuthor(objAuthor));
    }

    @Test
    public void checkValidDescription() throws Exception {
        assertEquals(isValidDescription, NewsListAdapter.isValidDescription(objDescription));
    }

    @Test
    public void checkValidUrlToImage() throws Exception {
        assertEquals(isValidUrlToImage, NewsListAdapter.isValidUrlToImage(objUrlToImage));
    }

    @Test
    public void checkValidSourceName() throws Exception {
        assertEquals(isValidSourceName, NewsListAdapter.isValidSourceName(strSourceName));
    }


    private static List<Article> getDummyData() {

        String responseString = "{\n" +
                "  \"status\": \"ok\",\n" +
                "  \"totalResults\": 36,\n" +
                "  \"articles\": [\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": null,\n" +
                "        \"name\": \"Bbc.com\"\n" +
                "      },\n" +
                "      \"author\": \"https://www.facebook.com/bbcnews\",\n" +
                "      \"title\": \"Brexit: May urged to quit to help deal pass - BBC News\",\n" +
                "      \"description\": \"Senior Tories may back the PM's deal if they know she will not lead the next stage of EU negotiations.\",\n" +
                "      \"url\": \"https://www.bbc.com/news/uk-politics-47683059\",\n" +
                "      \"urlToImage\": \"https://ichef.bbci.co.uk/news/1024/branded_news/11F67/production/_106157537_mediaitem106157536.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-24T03:16:17Z\",\n" +
                "      \"content\": \"Image copyright EPA Theresa May could gain support for her Brexit deal if she promises to stand down as PM, senior Conservatives have told the BBC. MPs in the party have said they might reluctantly back the agreement if they know she will not be in charge of … [+3529 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"cbs-news\",\n" +
                "        \"name\": \"CBS News\"\n" +
                "      },\n" +
                "      \"author\": \"CBS News\",\n" +
                "      \"title\": \"Powerball winning numbers: 24, 25, 52, 60, 66 and Powerball 5 - CBS News\",\n" +
                "      \"description\": \"There was no winner in the $638.8 million Powerball jackpot on Saturday\",\n" +
                "      \"url\": \"https://www.cbsnews.com/news/powerball-winning-numbers-jackpot-live-updates-2019-03-23/\",\n" +
                "      \"urlToImage\": \"https://cbsnews2.cbsistatic.com/hub/i/r/2017/08/22/79ded80e-3bcd-4f3d-a8bd-02f3d6119ff6/thumbnail/1200x630/8696f2d01dbddc95cad6cda437dcf5ec/powerball-gettyimages-504805794.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-24T03:06:00Z\",\n" +
                "      \"content\": \"There was no winner in the $638.8 million Powerball jackpot on Saturday, pushing the jackpot up to $750 million. The winning numbers drawn were 24, 25, 52, 60, and 66 and the Powerball number is 5. Powerball winning numbers 24, 25, 52, 60, and 66 Powerball: 5… [+1390 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": null,\n" +
                "        \"name\": \"Mmamania.com\"\n" +
                "      },\n" +
                "      \"author\": \"Jesse Holland\",\n" +
                "      \"title\": \"UFC Fight Night 148 results: Live streaming play-by-play updates for ‘Thompson vs Pettis’ on ESPN+ in Nashvil… - MMA Mania\",\n" +
                "      \"description\": \"UFC Fight Night 148 live stream results, play-by-play updates for “Thompson vs. Pettis” on ESPN+ TONIGHT (Sat., March 23, 2019) inside Bridgestone Arena in Nashville, Tennessee.\",\n" +
                "      \"url\": \"https://www.mmamania.com/2019/3/20/18274465/ufc-fight-night-148-results-live-streaming-play-by-play-updates-thompson-pettis-espn-nashville-mma\",\n" +
                "      \"urlToImage\": \"https://cdn.vox-cdn.com/thumbor/TbN_Al-1yrDxKgVrN73S54e9-8I=/0x75:4096x2379/1600x900/cdn.vox-cdn.com/uploads/chorus_image/image/63270426/NASHVILLE.0.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-24T03:03:00Z\",\n" +
                "      \"content\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": null,\n" +
                "        \"name\": \"Freep.com\"\n" +
                "      },\n" +
                "      \"author\": \"Chris Solari\",\n" +
                "      \"title\": \"Michigan State basketball pounds Minnesota, 70-50: Observations - Detroit Free Press\",\n" +
                "      \"description\": \"Michigan State Spartans pound Minnesota in 2019 NCAA tournament 2nd round to earn Sweet 16 berth, date with LSU\",\n" +
                "      \"url\": \"https://www.freep.com/story/sports/college/michigan-state/spartans/2019/03/23/michigan-state-basketball-minnesota-ncaa-tournament/3256231002/\",\n" +
                "      \"urlToImage\": \"https://www.gannett-cdn.com/presto/2019/03/24/PDTF/02939ed3-888b-44d9-8c54-d3f609263cb9-MichiganState_032319_kd2253.jpg?crop=2126,1196,x0,y160&width=3200&height=1680&fit=bounds\",\n" +
                "      \"publishedAt\": \"2019-03-24T02:36:38Z\",\n" +
                "      \"content\": \"Last Slide Next Slide DES MOINES, Iowa — At times, it was beautiful basketball. At times, it was some of the sloppiest Michigan State basketball has played in a while. None of the mistakes could keep the Spartans from moving on to their first Sweet 16 since 2… [+4881 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": null,\n" +
                "        \"name\": \"Tmz.com\"\n" +
                "      },\n" +
                "      \"author\": \"TMZ Staff\",\n" +
                "      \"title\": \"Dr. Dre Gloats Over Daughter's Acceptance Into USC with 'No Jail Time' - TMZ\",\n" +
                "      \"description\": \"Dr. Dre's rubbing a little salt in the wounds of Lori Loughlin and Felicity Huffman.\",\n" +
                "      \"url\": \"https://www.tmz.com/2019/03/23/dr-dre-gloats-over-daughters-acceptance-into-usc-with-no-jail-time/\",\n" +
                "      \"urlToImage\": \"https://images.tmz.com/2019/03/23/0323-dr-dre-daughter-usc-insta-2-1200x630.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-24T02:29:00Z\",\n" +
                "      \"content\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"fox-news\",\n" +
                "        \"name\": \"Fox News\"\n" +
                "      },\n" +
                "      \"author\": \"Associated Press\",\n" +
                "      \"title\": \"The Latest: Thai king warns about bad people gaining power - Fox News\",\n" +
                "      \"description\": \"The Latest on Thailand's general election (all times local): 9:10 a.m.\",\n" +
                "      \"url\": \"https://www.foxnews.com/world/the-latest-thai-king-warns-about-bad-people-gaining-power\",\n" +
                "      \"urlToImage\": \"https://static.foxnews.com/foxnews.com/content/uploads/2019/03/ContentBroker_contentid-9190ad3ca45c49a98f0a3751534a14c6.png\",\n" +
                "      \"publishedAt\": \"2019-03-24T02:27:15Z\",\n" +
                "      \"content\": \"BANGKOK The Latest on Thailand's general election (all times local): 9:10 a.m. Thailand's King Maha Vajiralongkorn has issued a statement as Thais vote in their first election since a 2014 coup that says the role of leaders is to stop \\\"bad people\\\" from gainin… [+1387 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"cbs-news\",\n" +
                "        \"name\": \"CBS News\"\n" +
                "      },\n" +
                "      \"author\": \"Caroline Linton\",\n" +
                "      \"title\": \"Pentagon identifies soldiers killed in Afghanistan - CBS News\",\n" +
                "      \"description\": \"The Pentagon said they died of wounds sustained while engaged in combat operations  in Kunduz Province, Afghanistan\",\n" +
                "      \"url\": \"https://www.cbsnews.com/news/afghanistan-pentagon-identifies-soldiers-killed-as-joseph-collette-will-lindsay/\",\n" +
                "      \"urlToImage\": \"https://cbsnews3.cbsistatic.com/hub/i/r/2019/03/24/99504ab8-fcc8-445c-a8ae-41e7128f8f33/thumbnail/1200x630/4bcd5ed471f878de983f2ce7a94fb970/afghanistan-american-soldiers-killed-2019-03-23.png\",\n" +
                "      \"publishedAt\": \"2019-03-24T02:22:00Z\",\n" +
                "      \"content\": \"The two soldiers killed in Afghanistan earlier this week were identified Saturday by the Defense Department as Spc. Joseph P. Collette, 29, of Lancaster, Ohio, and Sgt. 1st Class Will D. Lindsay, of Cortez, Colorado. The Pentagon said Saturday they died of wo… [+1910 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": null,\n" +
                "        \"name\": \"Etonline.com\"\n" +
                "      },\n" +
                "      \"author\": \"Liz Calvario\u200D\",\n" +
                "      \"title\": \"2019 Nickelodeon Kids' Choice Awards: Complete List of Winners - Entertainment Tonight\",\n" +
                "      \"description\": \"The winners were announced on Saturday, March 23.\",\n" +
                "      \"url\": \"https://www.etonline.com/2019-nickelodeon-kids-choice-awards-complete-list-of-winners-121794\",\n" +
                "      \"urlToImage\": \"https://www.etonline.com/sites/default/files/styles/max_1280x720/public/images/2019-03/gettyimages-1132362772.jpg?itok=8GJIi3Hn\",\n" +
                "      \"publishedAt\": \"2019-03-24T02:11:00Z\",\n" +
                "      \"content\": \"And the winners are… The 2019 Nickelodeon Kids' Choice Awards kicked off at the Galen Center in Los Angeles on Saturday. Hosted by DJ Khaled, a slew of actors, musicians, social media influencers and more attended the annual celebration -- and took home the f… [+6712 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": null,\n" +
                "        \"name\": \"Ndtv.com\"\n" +
                "      },\n" +
                "      \"author\": null,\n" +
                "      \"title\": \"Over 700 Killed In Africa Cyclone, UN Says More Floods Likely - NDTV News\",\n" +
                "      \"description\": \"Mozambique reported scores more deaths on Saturday from a cyclone and floods around southern Africa that have killed at least 732 people and left thousands in desperate need of help, many on rooftops and trees.\",\n" +
                "      \"url\": \"https://www.ndtv.com/world-news/more-than-700-killed-in-africas-cyclone-un-says-more-floods-likely-2011940\",\n" +
                "      \"urlToImage\": \"https://c.ndtvimg.com/2019-03/faqua2mg_africa_625x300_24_March_19.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-24T01:55:00Z\",\n" +
                "      \"content\": \"A woman stands besides a car that was swept away with debris by Cyclone Idai in Chimanimani. (Reuters) Beira: Mozambique reported scores more deaths on Saturday from a cyclone and floods around southern Africa that have killed at least 732 people and left tho… [+3094 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"nbc-news\",\n" +
                "        \"name\": \"NBC News\"\n" +
                "      },\n" +
                "      \"author\": \"Phil Helsel, Associated Press\",\n" +
                "      \"title\": \"Protests continue in Pittsburgh after officer acquitted in fatal shooting of Antwon Rose II - NBCNews.com\",\n" +
                "      \"description\": \"Shots were fired into the empty office of the attorney representing a white police officer acquitted Friday in the fatal shooting of unarmed black teen Antwon Rose II, and protests in Pittsburgh continued Saturday.\",\n" +
                "      \"url\": \"https://www.nbcnews.com/news/us-news/protests-continue-pittsburgh-after-officer-acquitted-fatal-shooting-antwon-rose-n986661\",\n" +
                "      \"urlToImage\": \"https://media3.s-nbcnews.com/j/newscms/2019_12/2796986/190323-antwon-rose-protest-ew-751p_1bb2d05ce76a2abec62b539dbb803bcc.nbcnews-fp-1200-630.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-24T01:17:00Z\",\n" +
                "      \"content\": \"Get breaking news alerts and special reports. The news and stories that matter, delivered weekday mornings. SUBSCRIBE March 24, 2019, 1:17 AM GMT By Phil Helsel and Associated Press Shots were fired into the Pennsylvania office of the attorney for a white pol… [+2870 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"the-new-york-times\",\n" +
                "        \"name\": \"The New York Times\"\n" +
                "      },\n" +
                "      \"author\": null,\n" +
                "      \"title\": \"Cruise Ship Near Norway With Nearly 1,400 Passengers Is Being Evacuated - The New York Times\",\n" +
                "      \"description\": \"Dramatic videos and photos on Twitter showed the ship listing, furniture sliding from one side to the other and water rushing on board.\",\n" +
                "      \"url\": \"https://www.nytimes.com/2019/03/23/world/europe/viking-sky-cruise-ship-evacuation.html\",\n" +
                "      \"urlToImage\": \"https://static01.nyt.com/images/2019/03/23/us/politics/23xp-ship/merlin_152508786_9cafc190-ba9a-4614-bdd7-ef811f275083-facebookJumbo.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-24T00:45:53Z\",\n" +
                "      \"content\": \"A cruise ship with nearly 1,400 passengers and crew members lost engine power in heavy winds and waves near the coast of Norway on Saturday, injuring several people and prompting a painstaking, hourslong evacuation, the authorities said. The evacuation of the… [+466 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"engadget\",\n" +
                "        \"name\": \"Engadget\"\n" +
                "      },\n" +
                "      \"author\": \"Jon Fingas\",\n" +
                "      \"title\": \"Updated 'Battlefield V' roadmap teases Pacific theater combat - Engadget\",\n" +
                "      \"description\": \"EA is teasing a major update to 'Battlefield V' that could include the war in the Pacific.\",\n" +
                "      \"url\": \"https://www.engadget.com/2019/03/23/battlefield-v-roadmap-teases-pacific-theater/\",\n" +
                "      \"urlToImage\": \"https://o.aolcdn.com/images/dims?thumbnail=1200%2C630&quality=80&image_uri=https%3A%2F%2Fo.aolcdn.com%2Fimages%2Fdims%3Fcrop%3D4034%252C2691%252C532%252C500%26quality%3D85%26format%3Djpg%26resize%3D1600%252C1067%26image_uri%3Dhttps%253A%252F%252Fs.yimg.com%252Fos%252Fcreatr-images%252F2019-03%252Fafa0e0a0-4d96-11e9-a7ff-f4095ca23997%26client%3Da1acac3e1b3290917d92%26signature%3D9bc6c769e89d56374395cdc615c04da16caf8109&client=amp-blogside-v2&signature=bd265162b616e44c4ff8221921577687a5f6815c\",\n" +
                "      \"publishedAt\": \"2019-03-24T00:43:23Z\",\n" +
                "      \"content\": \"There will be more to do in the intervening months, of course. On top of the planned updates for March through May (such as a Greek map and a Hardcore mode), the June introduction of Chapter 4 will introduce an as yet unnamed five-on-five close combat mode. T… [+537 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": null,\n" +
                "        \"name\": \"Fox5sandiego.com\"\n" +
                "      },\n" +
                "      \"author\": \"http://www.facebook.com/fox5sandiego\",\n" +
                "      \"title\": \"Avocado recall: Escondido company recalls fruit due to possible health risk - fox5sandiego.com\",\n" +
                "      \"description\": \"Henry Avocado Corporation is voluntarily recalling California-grown whole avocados sold in bulk at retail stores because of potential contamination, the San Diego-based company announced in a news release Saturday.\",\n" +
                "      \"url\": \"https://fox5sandiego.com/2019/03/23/avocado-recall-escondido-company-recalls-fruit-due-to-possible-health-risk/\",\n" +
                "      \"urlToImage\": \"https://tribkswb.files.wordpress.com/2019/03/avocadorecall.png\",\n" +
                "      \"publishedAt\": \"2019-03-24T00:33:00Z\",\n" +
                "      \"content\": \"Escondido, Calif. — Henry Avocado Corporation is voluntarily recalling California-grown whole avocados sold in bulk at retail stores because of potential contamination, the San Diego-based company announced in a news release Saturday. The company issued the v… [+1983 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"the-washington-post\",\n" +
                "        \"name\": \"The Washington Post\"\n" +
                "      },\n" +
                "      \"author\": \"https://www.facebook.com/paul.kane.3367\",\n" +
                "      \"title\": \"Democrats insist on pursuing Trump investigations no matter what Mueller concludes - The Washington Post\",\n" +
                "      \"description\": \"House Speaker Pelosi called Saturday for full disclosure of the special counsel’s report and said she would reject a classified briefing for select few lawmakers.\",\n" +
                "      \"url\": \"https://www.washingtonpost.com/politics/democrats-insist-on-pursuing-trump-investigations-no-matter-what-mueller-concludes/2019/03/23/1944fee2-4db5-11e9-b871-978e5c757325_story.html\",\n" +
                "      \"urlToImage\": \"https://www.washingtonpost.com/resizer/BikDfw3egXe9T5yuDIRNK3oRh6s=/1484x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/5NFMBBSNYII6TFTDACWHH5EWMI.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-24T00:06:18Z\",\n" +
                "      \"content\": \"Democrats have yet to see details of special counsel Robert S. Mueller IIIs report on President Trump and Russian interference in the 2016 election but are insisting they will press ahead with their investigations no matter what the conclusions. In a rare Sat… [+5540 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"nbc-news\",\n" +
                "        \"name\": \"NBC News\"\n" +
                "      },\n" +
                "      \"author\": \"Phil Helsel\",\n" +
                "      \"title\": \"Fraternity expels 4 at University of Georgia chapter after racist video surfaces - NBC News\",\n" +
                "      \"description\": \"The Tau Kappa Epsilon fraternity said it has expelled four members from a chapter at the University of Georgia after video surfaced showing people using a racial slur about black people and talking about picking cotton.\",\n" +
                "      \"url\": \"https://www.nbcnews.com/news/us-news/fraternity-expels-4-university-georgia-after-racist-video-surfaces-n986656\",\n" +
                "      \"urlToImage\": \"https://media1.s-nbcnews.com/j/newscms/2019_12/2796916/190323-university-of-georgia-ew-659p_52e8cd6639db00a1502c9ba5ca1b8f57.nbcnews-fp-1200-630.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-23T23:37:00Z\",\n" +
                "      \"content\": \"Get breaking news alerts and special reports. The news and stories that matter, delivered weekday mornings. SUBSCRIBE March 23, 2019, 11:37 PM GMT The Tau Kappa Epsilon fraternity said it has expelled four members at a chapter at the University of Georgia aft… [+2145 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"engadget\",\n" +
                "        \"name\": \"Engadget\"\n" +
                "      },\n" +
                "      \"author\": \"Mariella Moon\",\n" +
                "      \"title\": \"Chrome 74 beta supports dark mode in Windows - Engadget\",\n" +
                "      \"description\": \"Chrome 74 beta supports Windows dark mode and helps prevent motion sickness.\",\n" +
                "      \"url\": \"https://www.engadget.com/2019/03/23/chrome-74-beta-dark-mode-windows/\",\n" +
                "      \"urlToImage\": \"https://o.aolcdn.com/images/dims?thumbnail=1200%2C630&quality=80&image_uri=https%3A%2F%2Fo.aolcdn.com%2Fimages%2Fdims%3Fcrop%3D4288%252C2682%252C0%252C0%26quality%3D85%26format%3Djpg%26resize%3D1600%252C1001%26image_uri%3Dhttps%253A%252F%252Fs.yimg.com%252Fos%252Fcreatr-images%252F2019-03%252Ffe5d1810-4d7f-11e9-a9eb-d13dafe826a2%26client%3Da1acac3e1b3290917d92%26signature%3D194daffe6dfba921c1bc621a3a1fb6a5e39b77d1&client=amp-blogside-v2&signature=a4f7438fff5b12b6ae04c85f37e3c42d6c1902e4\",\n" +
                "      \"publishedAt\": \"2019-03-23T23:05:36Z\",\n" +
                "      \"content\": \"In addition, it looks like Chrome 74 could turn the browser into a better friend for those susceptible to motion sickness. It can instruct websites to respect your OS-level preferences when it comes to motion and animations. If you've switched on options such… [+986 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"fox-news\",\n" +
                "        \"name\": \"Fox News\"\n" +
                "      },\n" +
                "      \"author\": \"Paulina Dedaj\",\n" +
                "      \"title\": \"Barbra Streisand clarifies Michael Jackson abuse comments: 'I feel nothing but sympathy for them' - Fox News\",\n" +
                "      \"description\": \"Barbra Streisand issued a clarifying statement Saturday amid intense fallout over controversial remarks she'd made on a particularly thorny topic these days: Michael Jackson.\",\n" +
                "      \"url\": \"https://www.foxnews.com/entertainment/barbra-streisand-clarifies-michael-jackson-abuse-comments-i-feel-nothing-but-sympathy-for-them\",\n" +
                "      \"urlToImage\": \"https://static.foxnews.com/foxnews.com/content/uploads/2019/03/Babra-Getty.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-23T22:06:55Z\",\n" +
                "      \"content\": \"Barbra Streisand issued a clarifying statement Saturday amid intense fallout over controversial remarks she'd made on a particularly thorny topic these days: Michael Jackson. Controversy has lately been swirling around Jackson, following a recent HBO document… [+2019 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": null,\n" +
                "        \"name\": \"Bbc.com\"\n" +
                "      },\n" +
                "      \"author\": \"https://www.facebook.com/bbcnews\",\n" +
                "      \"title\": \"Trump hails fall of Islamic State 'caliphate' in Syria - BBC News\",\n" +
                "      \"description\": \"The Islamic State group remains a threat despite the fall of its final territory, President Trump says.\",\n" +
                "      \"url\": \"https://www.bbc.com/news/world-middle-east-47682160\",\n" +
                "      \"urlToImage\": \"https://ichef.bbci.co.uk/images/ic/1024x576/p074d52z.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-23T20:35:12Z\",\n" +
                "      \"content\": \"Media caption Kurdish TV showed the SDF raising a yellow flag on top of buildings seized from IS in Baghuz US President Donald Trump welcomed the fall of the Islamic State group's five-year \\\"caliphate\\\", but warned that the terror group remained a threat. Mr T… [+3752 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"fox-news\",\n" +
                "        \"name\": \"Fox News\"\n" +
                "      },\n" +
                "      \"author\": \"Associated Press\",\n" +
                "      \"title\": \"New beer will quench your thirst -- and develop your movie film? - Fox News\",\n" +
                "      \"description\": \"\",\n" +
                "      \"url\": \"https://www.foxnews.com/lifestyle/new-beer-will-quench-your-thirst-and-develop-your-movie-film\",\n" +
                "      \"urlToImage\": \"https://static.foxnews.com/foxnews.com/content/uploads/2019/03/19082658763010.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-23T20:12:09Z\",\n" +
                "      \"content\": \"Kodak says a new beer hitting the market can be used to develop its Super 8 movie film. Dogfish Head Craft Brewery in Delaware created its SuperEIGHT beer after a conversation with people at Kodak, the upstate New York technology company most famous for its p… [+562 chars]\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": null,\n" +
                "        \"name\": \"Cnet.com\"\n" +
                "      },\n" +
                "      \"author\": \"Joan E. Solsman\",\n" +
                "      \"title\": \"Apple’s TV streaming and news party may end with hangover for rivals - CNET\",\n" +
                "      \"description\": \"Apple's Monday event is expected to be an extravaganza of subscription services: TV! Movies! News! Bundles! But competitors say the company is already out of control.\",\n" +
                "      \"url\": \"https://www.cnet.com/news/apples-tv-streaming-and-news-party-may-end-with-hangover-for-rivals/\",\n" +
                "      \"urlToImage\": \"https://cnet2.cbsistatic.com/img/s4vbe29FdmnxSL2VarWuUeuAChc=/724x407/2019/03/23/f9987987-68ac-42f3-87f1-ac2dcf210ee9/gettyimages-599947342.jpg\",\n" +
                "      \"publishedAt\": \"2019-03-23T19:58:00Z\",\n" +
                "      \"content\": \"Slick new gadgets are usually the stars of Apple 's splashy events. But on Monday, the company will put the spotlight on subscriptions and services. A star-studded new TV service is expected to headline Apple's event at the Steve Jobs Theater in Cupertino, Ca… [+7314 chars]\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        NewsApiDO newsApiDO = new Gson().fromJson(responseString, NewsApiDO.class);
        return newsApiDO.articles;
    }
}

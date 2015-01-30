package com.beasty.transitionold;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.transition.Transition;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


public class DetailActivity extends ActionBarActivity {

    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_AVATAR_URL = "extra_avatar";
    public static final String EXTRA_ID = "extra_id";
    public static final String TRANSITION_AVATAR = "avatar_band";
    public static final String TRANSITION_TITLE = "title_band";

    private String title;
    private String avatarUrl;

    private TextView titleView;
    private ImageView coverView;
    private ScrollView scrollView;
    private int primaryDark;
    private int accent;
    private int accentLight;
    private TextView contentView;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra(EXTRA_TITLE);
            avatarUrl = intent.getStringExtra(EXTRA_AVATAR_URL);
            id = intent.getIntExtra(EXTRA_ID,0);
        }

        mapUi();
        initValue();
    }

    private void mapUi() {
        titleView = ((TextView) findViewById(R.id.tv_detail_title));
        contentView = ((TextView) findViewById(R.id.tv_detail_content));
        coverView = ((ImageView) findViewById(R.id.iv_detail_cover));
        scrollView = ((ScrollView) findViewById(R.id.sv_detail_scroll));

        primaryDark = getResources().getColor(R.color.theme_default_primary_dark);
        accent = getResources().getColor(R.color.theme_default_accent);
        accentLight = getResources().getColor(R.color.theme_default_accent_light);

    }

    private void initValue() {
        ViewCompat.setTransitionName(coverView, TRANSITION_AVATAR);
        ViewCompat.setTransitionName(titleView, TRANSITION_TITLE);

        titleView.setText(title);
        contentView.setText(desc[id]);

        if ((avatarUrl != null) && !avatarUrl.equals("") ) {
            Picasso.with(getBaseContext()).load(avatarUrl).noFade()
                    .into(imageLoaded);
        }
    }

    private Target imageLoaded = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            Palette palette = Palette.generate(bitmap);

            coverView.setImageBitmap(bitmap);

            scrollView.setBackgroundColor(palette.getDarkMutedColor(primaryDark));
            titleView.setTextColor(palette.getVibrantColor(accent));
            contentView.setTextColor(palette.getLightVibrantColor(accentLight));
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            scrollView.setBackgroundColor(primaryDark);
            titleView.setBackgroundColor(accent);
            contentView.setBackgroundColor(accentLight);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

    private final static String[] desc = {
            "Beastie Boys were an American hip hop band from New York City, formed in 1981. For the majority of its career, the group consisted of Michael \"Mike D\" Diamond (vocals, drums), Adam \"MCA\" Yauch (vocals, bass) and Adam \"Ad-Rock\" Horovitz (vocals, guitar).\n" +
                    "\n" +
                    "Originally formed as a four-piece hardcore punk band in 1981 by Diamond (vocals), John Berry (guitar), Yauch (bass) and Kate Schellenbach (drums), the band appeared on the compilation cassette New York Thrash, before recording their first EP Polly Wog Stew in 1982. Berry left shortly thereafter, and was replaced by Horovitz. After achieving moderate local success with the 1983 experimental hip hop 12-inch \"Cooky Puss\", Schellenbach dropped out and the group made a full transition to hip hop, releasing a string of successful singles. The Beastie Boys toured with Madonna in 1985 and a year later released their debut album Licensed to Ill. The group sold 22 million albums in the United States and 40 million albums worldwide, making them, according to Billboard, \"the biggest-selling rap group\" since 1991.[2]\n" +
                    "\n" +
                    "With seven platinum or better albums from 1986–2004,[3] the Beastie Boys were one of the longest-lived hip hop acts worldwide. In 2009, the group released digitally remastered deluxe editions of their albums Paul's Boutique, Check Your Head, Ill Communication and Hello Nasty. Their eighth studio album, Hot Sauce Committee Part Two, was released in 2011,[4] and received positive reviews.[5] They were inducted into the Rock and Roll Hall of Fame in April 2012, \"just the third rap group to enter the Hall, after Run-D.M.C. (2009) and Grandmaster Flash and the Furious Five (2007).\" [6] The following month, MCA died of cancer of the parotid salivary gland.[7]",
            "Kevin Donovan (born April 17, 1957), better known by the stage name Afrika Bambaataa, is an American DJ from the South Bronx, New York.[1][2] He is notable for releasing a series of genre-defining electro tracks in the 1980s that influenced the development of hip hop culture.[3] Afrika Bambaataa is one of the originators of breakbeat DJing and is respectfully known as \"The Godfather\" and \"Amen Ra of Hip Hop Kulture,\" as well as the father of electro funk.[4] Through his co-opting of the street gang the Black Spades into the music and culture-oriented Universal Zulu Nation, he has helped spread Hip Hop Culture throughout the world.[2]",
            "Tupac Amaru Shakur (/ˈtuːpɑːk ʃəˈkʊər/ too-pahk shə-koor;[1] June 16, 1971 – September 13, 1996), also known by his stage names 2Pac and briefly as Makaveli, was an American rapper, songwriter, and actor.[2] Shakur has sold over 75 million records worldwide, making him one of the best-selling music artists of all time.[3] His double disc albums All Eyez on Me and his Greatest Hits are among the best selling albums in the United States.[4] He has been listed and ranked as one of the greatest artists of all time by many magazines, including Rolling Stone which ranked him 86th on its list of The 100 Greatest Artists of All Time.[5] Consistently ranked as one of the greatest rappers ever, he was ranked number 2 by MTV in their list of The Greatest MCs of All-Time in 2006.[6] 2Pac is also ranked as the most influential rapper of all time.[7][8][9][10][11]\n" +
                    "\n" +
                    "Shakur began his career as a roadie, backup dancer, and MC for the alternative hip hop group Digital Underground, eventually branching off as a solo artist.[12][13][14] The themes of most of Shakur's songs revolved around the violence and hardship in inner cities, racism and other social problems. Both of his parents and several other of his family were members of the Black Panther Party, whose ideals were reflected in his songs.\n" +
                    "\n" +
                    "During the latter part of his career, Shakur was a vocal participant in the so-called East Coast–West Coast hip hop rivalry, becoming involved in conflicts with other rappers, producers and record-label staff members, most notably The Notorious B.I.G. and the label Bad Boy Records.[15]\n" +
                    "\n" +
                    "On September 7, 1996, Shakur was shot multiple times in a drive-by shooting at the intersection of Flamingo Road and Koval Lane in Las Vegas, Nevada.[16] He was taken to the University Medical Center of Southern Nevada, where he died six days later.[17]",
            "Public Enemy is an American hip hop group consisting of Chuck D, Flavor Flav, DJ Lord, The S1W group, Khari Wynn and Professor Griff. Formed in Long Island, New York in 1982, they are known for their politically charged lyrics and criticism of the American media, with an active interest in the frustrations and concerns of the African American community. Their first four albums during the late 1980s and early 1990s were all certified either gold or platinum and were, according to music critic Robert Hilburn, \"the most acclaimed body of work ever by a rap act.\"[1] In 2004, Rolling Stone magazine ranked Public Enemy[2] number 44 on its list of the Immortals: 100 Greatest Artists of All Time.[3] The group was inducted into the Long Island Music Hall of Fame in 2007.[4] The band were announced as inductees for the 2013 class of the Rock and Roll Hall of Fame on December 11, 2012, making them the fourth hip-hop act to be inducted after Grandmaster Flash and the Furious Five, Run–D.M.C. and The Beastie Boys.[5]",
            "De La Soul is an American hip hop trio formed in 1987 on Long Island, New York.[2] The band is best known for their eclectic sampling, quirky lyrics, and their contributions to the evolution of the jazz rap and alternative hip hop subgenres. The members are Kelvin Mercer, David Jude Jolicoeur and Vincent Mason. The three formed the group in high school and caught the attention of producer Prince Paul with a demo tape of the song \"Plug Tunin'\". With its playful wordplay, innovative sampling, and witty skits, the band's debut album, 3 Feet High and Rising, has been called \"a hip hop masterpiece.\"[3]\n" +
                    "\n" +
                    "It is the band's biggest commercial success to date, with their subsequent albums selling progressively less, despite receiving high praise from critics. They were influential in the early stages of rapper/actor Mos Def's career, and are a core part of the Spitkicker collective. They are the second longest standing Native Tongues Posse group, after the Jungle Brothers. In 2006, the group won a Grammy for their collaboration with Gorillaz on the single \"Feel Good Inc.\"[4]",
            "Calvin Cordozar Broadus, Jr.[5][6]<[7] (born October 20, 1971), known by his stage names Snoop Doggy Dogg, Snoop Dogg, and later Snoop Lion, is an American rapper, singer-songwriter and actor. Snoop has sold over 30 million albums worldwide. His music career began in 1992 when he was discovered by Dr. Dre. He collaborated on Dre's solo debut The Chronic (1992), and on the theme song to the feature film Deep Cover.\n" +
                    "\n" +
                    "Snoop's debut album, Doggystyle, was released in 1993 under Death Row Records, debuting at No. 1 on both the Billboard 200 and Billboard Hot R&B/Hip-Hop Songs charts. Selling almost a million copies in the first week of its release, Doggystyle became certified 4× platinum in 1994 and spawned several hit singles, including \"What's My Name\" and \"Gin & Juice\". In 1994, Snoop released a soundtrack on Death Row Records for the short film Murder Was The Case, starring himself. His second album Tha Doggfather (1996), also debuted at No. 1 on both charts with \"Snoop's Upside Ya Head\" as the lead single. The album was certified double platinum in 1997.\n" +
                    "\n" +
                    "After leaving Death Row, Snoop signed with No Limit Records, where he recorded his next three albums. Da Game Is to Be Sold, Not to Be Told (1998), No Limit Top Dogg (1999), and Tha Last Meal (2000). Snoop then signed with Priority/Capitol/EMI Records in 2002, where he released Paid tha Cost to Be da Boss. He then signed with Geffen Records in 2004 for his next three albums R&G (Rhythm & Gangsta): The Masterpiece, Tha Blue Carpet Treatment, and Ego Trippin'. Malice 'n Wonderland (2009) and Doggumentary (2011), were released on Priority. Snoop Dogg has starred in motion pictures and hosted several television shows including, Doggy Fizzle Televizzle, Snoop Dogg's Father Hood, and Dogg After Dark. He also coaches a youth football league and high school football team. In September 2009, Snoop was hired by EMI as the chairman of a reactivated Priority Records.[8]\n" +
                    "\n" +
                    "In 2012, after a trip to Jamaica, Snoop announced a conversion to the Rastafari movement and a new alias, Snoop Lion. Under the new moniker, he released a reggae album, Reincarnated, and a documentary film of the same name, of his Jamaican experience, in early 2013. He is currently working on his last solo studio album under his rap moniker Snoop Dogg.",
            "Christopher George Latore Wallace (May 21, 1972 – March 9, 1997), better known by his stage names The Notorious B.I.G., Biggie or Biggie Smalls,[2] was an American rapper.\n" +
                    "\n" +
                    "Wallace was raised in the Brooklyn borough of New York City. When he released his debut album Ready to Die in 1994, he became a central figure in the East Coast hip hop scene and increased New York's visibility in the genre at a time when West Coast hip hop was dominant in the mainstream.[3] The following year, Wallace led his childhood friends to chart success through his protégé group, Junior M.A.F.I.A. While recording his second album, Wallace was heavily involved in the growing East Coast/West Coast hip hop feud.\n" +
                    "\n" +
                    "On March 9, 1997, Wallace was killed by an unknown assailant in a drive-by shooting in Los Angeles. His double-disc set Life After Death, released 16 days later, rose to No. 1 on the U.S. album charts and was certified Diamond in 2000, one of the few hip hop albums to receive this certification.[4] Wallace was noted for his \"loose, easy flow\",[5] dark semi-autobiographical lyrics and storytelling abilities. Two more albums have been released since his death. He has certified sales of 17 million units in the United States.",
            "Andre Romelle Young (born February 18, 1965), known by his stage name Dr. Dre, is an American record producer, rapper and entrepreneur. He is the founder and current CEO of Aftermath Entertainment and Beats Electronics. Dre was previously the co-owner of, and an artist on, Death Row Records. He has produced albums for and overseen the careers of many rappers, including Snoop Dogg, Eminem, Xzibit, 50 Cent, The Game, and Kendrick Lamar. He is credited as a key figure in the popularization of West Coast G-funk, a style of rap music characterized as synthesizer-based with slow, heavy beats. In 2014, Dr. Dre was ranked as the second richest figure in the American hip hop scene by Forbes with a net worth of $550 million.[3]\n" +
                    "\n" +
                    "Dre began his career as a member of the World Class Wreckin' Cru and later found fame with the influential gangsta rap group N.W.A with Eazy-E, Ice Cube, MC Ren, and DJ Yella, which popularized the use of explicit lyrics in rap to detail the violence of street life. His 1992 solo debut The Chronic, released under Death Row Records, led him to become one of the best-selling American performing artists of 1993 and to win a Grammy Award for the single \"Let Me Ride\". That same year he produced Death Row labelmate Snoop Dogg's quadruple platinum debut Doggystyle.\n" +
                    "\n" +
                    "In 1996, he left Death Row Records to establish his own label, Aftermath Entertainment. He produced a compilation album titled Dr. Dre Presents the Aftermath in 1996, and released a solo album titled 2001 in 1999. During the 2000s, he focused on production for other artists, while occasionally contributing vocals to songs. Dr. Dre signed Eminem and 50 Cent to his record label in 1998 and 2002 respectively, while contributing production on their albums. He has won six Grammy Awards, including Producer of the Year. Dr. Dre has also had acting roles in movies such as Set It Off, The Wash and Training Day. Rolling Stone ranked Dre at 56 on their list of \"100 Greatest Artists of All-Time\".",
            "Cypress Hill are an American hip hop group from South Gate, California. Cypress Hill was the first Latino-American hip hop group to have platinum and multi-platinum albums, selling over 18 million albums worldwide. They are considered to be amongst the main progenitors of West Coast rap and Hip hop in the early 1990s, being critically acclaimed for their first two albums.[1] The band has also been important for the advocacy of medical and recreational use of cannabis in the United States.[2]",
            "El Club de los Poetas Violentos, también conocidos como CPV es un grupo de rap de Madrid (España).\n" +
                    "\n" +
                    "Formado por El Meswy (MC), Jota Mayúscula (DJ), Kamikaze (MC), Mr. Rango (MC), Paco King (MC) y Supernafamacho (MC). Además de estos, Frank-T (MC) formó parte del grupo en su primer LP Madrid, zona bruta.",
            "The Treacherous Three was a pioneering hip hop group that was formed in 1978 and consisted of DJ Easy Lee, Kool Moe Dee, L.A. Sunshine, Special K and Spoonie Gee (who left in the late 1970s), with occasional contributions from DJ Dano B, DJ Reggie Reg and DJ Crazy Eddie. They first appeared on record in 1980 on the B side of Spoonie Gee's single Love Rap."
    };


}

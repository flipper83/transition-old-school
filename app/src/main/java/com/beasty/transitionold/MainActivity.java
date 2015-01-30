package com.beasty.transitionold;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.beasty.transitionold.adapter.FeedAdapter;
import com.beasty.transitionold.view.model.FeedViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private RecyclerView feedBandList;
    private FeedAdapter feedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapUi();
    }

    private void mapUi() {
        feedBandList = ((RecyclerView) findViewById(R.id.feed_band));
    }

    @Override
    protected void onResume() {
        super.onResume();

        refreshAdapter();
    }

    private void refreshAdapter() {
        if(feedAdapter == null){
            feedAdapter = new FeedAdapter(initValues(),getBaseContext());

            feedBandList.setHasFixedSize(true);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            feedBandList.setLayoutManager(layoutManager);

            feedBandList.setAdapter(feedAdapter);
        } else {
            feedAdapter.notifyDataSetChanged();
        }
    }

    private final static String[] bands = {
            "The Beastie Boys",
            "Afrika Bambaataa",
            "2pac",
            "Public Enemy",
            "De La Soul",
            "Snoop Dogg",
            "Notorious B.I.G.",
            "Dr. Dre",
            "Cypress Hill",
            "CPV",
            "Treacherous Three"
    };

    private final static String[] avatars = {
            "http://www.fundacionlafuente.cl/wp-content/uploads/2014/10/beastie-boys.jpg",
            "http://www.funkhauseuropa.de/musik/globalpopnews/afrikabambaataa100_v-TeaserAufmacher.jpg",
            "http://www.garuyo.com/web/media/images/images/2pac-65.jpg",
            "http://static.guim.co.uk/sys-images/Music/Pix/pictures/2011/8/10/1312992525744/Public-Enemy--007.jpg",
            "http://mediad.publicbroadcasting.net/p/shared/npr/201312/258160660.jpg",
            "http://p1cdn03.thewrap.com/images/2014/06/snoop.dogg_.140603.jpg",
            "http://cdn.popdust.com/wp-content/uploads/2011/03/NotoriousBIG_GettyImages_97348258.jpg",
            "https://seatgeek.com/tba/wp-content/uploads/2013/04/Screen-Shot-2013-04-12-at-10.49.31-AM.png",
            "http://www.mehaceruido.com/wp-content/uploads/2010/11/cypresshill1.jpg",
            "http://lafonoteca.net/wp-content/uploads/2007/06/el-club-de-los-poetas-violentos.jpg",
            "http://www.conceptoradio.net/wp-content/uploads/2013/12/Dj+Tony+Tone+LA+Sunshine+and+Grandmaster+Caz+1981.jpg"
    };

    private List<FeedViewModel> initValues() {
        List<FeedViewModel> values = new ArrayList<>();

        for (int i = 0; i < bands.length; i++) {
            FeedViewModel feedViewModel = new FeedViewModel(bands[i], avatars[i],i);
            values.add(feedViewModel);
        }

        return values;
    }


}

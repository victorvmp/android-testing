package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

/**
 * CoordinatorSwipeToRefreshActivity
 *
 * @author <a href="mailto:info@movilok.com">Movilok Interactividad Movil S.L.</a>
 */
public class CoordinatorSwipeToRefreshActivity extends Activity {

  private RecyclerView recycler;
  private AppBarLayout appBarLayout;
  private Toolbar toolbar;
  private SwipeRefreshLayout swipeRefreshLayout;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_coordinator_swipe_to_refresh);

    recycler = (RecyclerView) findViewById(R.id.recycler);
    appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);

    recycler.setHasFixedSize(true);
    LinearLayoutManager lManager = new LinearLayoutManager(this);
    recycler.setLayoutManager(lManager);

    toolbar.setTitle("Example");

    swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        retrieveModelData();
      }
    });
  }

  private void retrieveModelData() {
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        setFakeListData();
      }
    }, 3000);
  }

  private void setFakeListData() {
    ItemAdapter adapter= new ItemAdapter(this);
    recycler.setAdapter(adapter);
  }
}

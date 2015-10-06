package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * CoordinatorSwipeToRefreshActivity
 *
 * @author <a href="mailto:info@movilok.com">Movilok Interactividad Movil S.L.</a>
 */
public class SwipeToRefreshActivity extends Activity {

  private RecyclerView recycler;
  private SwipeRefreshLayout swipeRefreshLayout;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_swipe_to_refresh);

    recycler = (RecyclerView) findViewById(R.id.recycler);
    swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);

    recycler.setHasFixedSize(true);
    LinearLayoutManager lManager = new LinearLayoutManager(this);
    recycler.setLayoutManager(lManager);

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
    swipeRefreshLayout.setEnabled(true);
    swipeRefreshLayout.setRefreshing(false);
    swipeRefreshLayout.setNestedScrollingEnabled(true);
    ItemAdapter adapter = new ItemAdapter(this);
    recycler.setAdapter(adapter);
  }
}

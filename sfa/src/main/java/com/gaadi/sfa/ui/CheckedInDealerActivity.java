package com.gaadi.sfa.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gaadi.sfa.R;
import com.gaadi.sfa.adapter.DealerAddItemAdapter;
import com.gaadi.sfa.adapter.DealerVisitedAdapter;
import com.gaadi.sfa.model.BaseResponseModel;
import com.gaadi.sfa.model.DealerModel;
import com.gaadi.sfa.retrofit.RetrofitRequest;
import com.gaadi.sfa.utils.AppConstants;
import com.gaadi.sfa.utils.AppPrefrences;
import com.gaadi.sfa.utils.Logger;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CheckedInDealerActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    public static final String EXTRA_DEALER_MODEL = "extra_dealer_model";
    public static final String EXTRA_VISIT_ID = "extra_visit_id";
    public View view_id;
    public ListPopupWindow listPopupWindow;
    EditText productName;
    String[] products = {"Care 1", "Laptop", "Watch", "Smartphone",
            "Television"};
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    private View view_purpose, view_conclusion;
    private boolean check_view = true;
    private RecyclerView recyclerView, recyclerMoreView;
    private LinearLayout parent_purpose, parent_conclusion;
    private TextView tv_next_check;
    private DealerAddItemAdapter dealerAddItemAdapter;

    private DealerModel dealerModel;
    private String visitId;

    private ProgressDialog progressDialog;
    private String TAG = "CheckedInDealerActivity";
    private TextView tv_name,tv_company_name;

    private void checkOutCustomer(final DealerModel model,String dealerStatus,String comment,String nextFollowup,String isJoinVisit,String reasons,String joined){

        progressDialog=ProgressDialog.show(this,"","Please wait check-out in progress...",true,false);

        RetrofitRequest.requestCheckOut(AppPrefrences.getLoginResponseModel(this).getLoginData().getEmail(),
                AppPrefrences.getLoginResponseModel(this).getLoginData().getPassword(),
                AppConstants.CHECKIN_DEALER,
                model.getDealerId(),
                /*dealerStatus*/"1",
                /*comment*/"I am not happy",
                /*nextFollowup*/"16-03-12 04:32:12",
                /*isJoinVisit*/"No",
                /*reasons*/"1,2,3",
                /*joined*/"[{\"role\":\"CE\",\"name\":\"abc\"},{\"role\":\"CE\",\"name\":\"xyz\"}]",
                model.getLatitude(),
                model.getLongitude(),
                visitId,
                new Callback<BaseResponseModel>() {

                    @Override
                    public void success(BaseResponseModel responseModel, Response response) {
                        progressDialog.dismiss();

                        if (responseModel.isResultSuccess()) {
                            Intent intent = new Intent(CheckedInDealerActivity.this, CheckedInDealerActivity.class);
                            intent.putExtra(CheckedInDealerActivity.EXTRA_DEALER_MODEL, model);
                            startActivity(intent);
                        } else
                            Toast.makeText(CheckedInDealerActivity.this, responseModel.getErrors().get(0), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        error.printStackTrace();
                        Logger.e(TAG, "error: " + error.getMessage());
                        progressDialog.dismiss();
                        Toast.makeText(CheckedInDealerActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_checked_in_dealer, frameLayout);
        setInitializationView();

        if(getIntent()!=null && getIntent().hasExtra(EXTRA_DEALER_MODEL))
            dealerModel = (DealerModel)getIntent().getSerializableExtra(EXTRA_DEALER_MODEL);

        if(getIntent()!=null && getIntent().hasExtra(EXTRA_VISIT_ID))
            visitId=getIntent().getStringExtra(EXTRA_VISIT_ID);

        Logger.e(TAG,"VisitId:"+visitId);
    }

    public void setDataInView()
    {
        
       /// findViewById(R.id.tv_company_name).

    }

    public void setInitializationView() {
        recyclerView = (RecyclerView) findViewById(R.id.visited_recycler_view);
        recyclerMoreView = (RecyclerView) findViewById(R.id.recycler_more_view);
        tv_company_name= (TextView) findViewById(R.id.tv_company_name);
        tv_name= (TextView) findViewById(R.id.tv_name);

        recyclerView.setHasFixedSize(true);
        recyclerMoreView.setHasFixedSize(true);
        parent_purpose = (LinearLayout) findViewById(R.id.parent_purpose);
        findViewById(R.id.lay_more).setOnClickListener(this);

        parent_purpose.setOnClickListener(this);
        parent_conclusion = (LinearLayout) findViewById(R.id.parent_conclusion);
        tv_next_check = (TextView) findViewById(R.id.tv_next_cheack);
        tv_next_check.setOnClickListener(this);
        parent_conclusion.setVisibility(View.GONE);
        parent_conclusion.setOnClickListener(this);

        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        ArrayList item = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            item.add(i, "Item add" + i + "");
        }

        DealerVisitedAdapter dealerVisitedAdapter = new DealerVisitedAdapter(this, item);
        recyclerView.setAdapter(dealerVisitedAdapter);
        dealerVisitedAdapter.SetOnItemClickListener(new DealerVisitedAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(CheckedInDealerActivity.this, "hello" + position, Toast.LENGTH_LONG).show();
            }
        });

        ArrayList item1 = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            item1.add(i, "Item add" + i + "");
        }
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        dealerAddItemAdapter = new DealerAddItemAdapter(this, item1);
        recyclerMoreView.setLayoutManager(linearLayoutManager);
        recyclerMoreView.setAdapter(dealerAddItemAdapter);
        dealerAddItemAdapter.SetOnItemClickListener(new DealerAddItemAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                view_id = v;
                if (v.getId() == R.id.et_role) {
                    listPopupWindow.show();


                }


                Toast.makeText(CheckedInDealerActivity.this, "hello" + position, Toast.LENGTH_LONG).show();
            }
        });

        ListPopupWindowList();
    }

    public void ListPopupWindowList() {
        listPopupWindow = new ListPopupWindow(
                CheckedInDealerActivity.this);
        listPopupWindow.setAdapter(new ArrayAdapter(
                CheckedInDealerActivity.this,
                R.layout.list_item_view, products));
        listPopupWindow.setAnchorView(productName);
        listPopupWindow.setWidth(300);
        listPopupWindow.setHeight(400);

        listPopupWindow.setModal(true);
        listPopupWindow.setOnItemClickListener(CheckedInDealerActivity.this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())

        {
            case R.id.tv_next_cheack:
                if (check_view) {
                    if (parent_purpose.getVisibility() == View.VISIBLE) {
                        parent_purpose.setVisibility(View.GONE);
                        parent_conclusion.setVisibility(View.VISIBLE);
                        tv_next_check.setText("CHECKOUT");

                    }

                    check_view = false;
                } else {
//                    if (parent_conclusion.getVisibility() == View.VISIBLE) {
//                        parent_conclusion.setVisibility(View.GONE);
//                        parent_purpose.setVisibility(View.VISIBLE);
//
//                        tv_next_check.setText("NEXT");
//
//                    }
//                    check_view = true;
                    checkOutCustomer(dealerModel,"","","","","","");
                }
            case R.id.lay_more:
                dealerAddItemAdapter.addItem("Item add");

        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        ///view.et_name.setText(products[position]);
        listPopupWindow.dismiss();
    }
}

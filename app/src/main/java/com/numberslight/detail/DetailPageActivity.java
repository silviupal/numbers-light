package com.numberslight.detail;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.numberslight.Constants;
import com.numberslight.R;
import com.numberslight.extention.ActivityExtKt;
import com.numberslight.model.DetailItemModel;
import com.numberslight.model.ItemModel;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Silviu Pal on 18/02/2019.
 */
public class DetailPageActivity extends AppCompatActivity implements DetailPageContract.View {
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;

    private DetailPagePresenter presenter;
    private DetailItemModel detailItemModel;

    public int getLayoutId() {
        return R.layout.detail_page_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this, this);
        setBackButtonTrue();

        if (savedInstanceState != null) {
            detailItemModel = (DetailItemModel) savedInstanceState.getParcelable(Constants.SAVED_DETAIL_ITEM);
            if (detailItemModel != null) {
                updateUI(detailItemModel);
            }
        } else if (getIntent() != null && getIntent().hasExtra(Constants.EXTRA_ITEM)) {
            ItemModel itemModel = (ItemModel) getIntent().getParcelableExtra(Constants.EXTRA_ITEM);
            if (itemModel != null) {
                initPresenter();
                presenter.getData(itemModel.getName());
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
        }
        return true;
    }

    @Override
    public void updateUI(@NotNull DetailItemModel item) {
        detailItemModel = item;
        Picasso.get().load(item.getImage())
                .placeholder(android.R.drawable.ic_dialog_info)
                .into(imageView);
        textView.setText(item.getText());
    }

    @Override
    public void showError(int errorRes) {
        ActivityExtKt.showToast(this, getString(errorRes));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Constants.SAVED_DETAIL_ITEM, detailItemModel);
    }

    private void setBackButtonTrue() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.detail_activity_name);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initPresenter() {
        presenter = new DetailPagePresenter();
        presenter.attachPresenter(this);
    }

}

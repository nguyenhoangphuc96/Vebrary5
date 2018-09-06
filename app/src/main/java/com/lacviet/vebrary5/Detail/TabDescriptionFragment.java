package com.lacviet.vebrary5.Detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lacviet.vebrary5.R;
import com.squareup.picasso.Picasso;

import static com.lacviet.vebrary5.MainActivity.toolbar;


public class TabDescriptionFragment extends Fragment {
    TextView tvName, tvAuthor, tvPublisher,tvEdition,tvTheme, tvSumary;
    ImageView imvDetail;
    ProgressBar pbImv;
    //
    LinearLayout loSame;
    ScrollView scrollView;
    //
    CircularCompletionView circularCompletionView;

    public TabDescriptionFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_description,container,false);
        addControl(view);
        setMarginRCV(view);
        tempData();
        addCircularView(view);
        return view;
    }

    private void addCircularView(View view) {
        circularCompletionView = view.findViewById(R.id.circularView);
        float persent = ((float)5/12)*100;
        circularCompletionView.setCompletionPercentage(persent);
        circularCompletionView.setTextSize(16);
        circularCompletionView.setStrokeSize(5);
    }

    private void setMarginRCV(View view) {
        loSame = view.findViewById(R.id.loSame);
        scrollView = view.findViewById(R.id.scrollView);
        ViewTreeObserver vto = toolbar.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightLoWrite = loSame.getMeasuredHeight();
                int marginDimen = (int) getActivity().getResources().getDimension(R.dimen.margin_button_bluelight);
                ViewGroup.MarginLayoutParams marginLayoutParams =
                        (ViewGroup.MarginLayoutParams) scrollView.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, heightLoWrite+(marginDimen*2));
                scrollView.setLayoutParams(marginLayoutParams);
            }
        });
    }
    private void tempData() {
        pbImv.setVisibility(View.GONE);
        tvName.setText("KHOA HỌC VÀ CÔNG NGHỆ NANO");
        tvAuthor.setText("Trương, Văn Tân ,");
        tvPublisher.setText("Đại học Quốc gia Tp. Hồ Chí Minh , 2014");
        tvEdition.setText("Tái bản có cập nhật, bổ sung");
        tvTheme.setText("Nanotechnology");
        tvSumary.setText("Khoa học và công nghệ nano là một bộ môn khảo sát, tìm hiểu đặc tính của những vật chất cực nhỏ, để thao tác, chồng chập những vật chất này, xây dựng vật thể to hơn. Người ta gọi phương pháp xây dựng từ vật nhỏ đến vật to và to hơn nữa là phương pháp \"từ dưới lên\". Sự xuất hiện của khoa học và công nghệ nano đang cách mạng hóa lề lối suy nghĩ và phương pháp thiết kế toàn thể các loại vật liệu, từ dược phẩm trị liệu đến các linh kiện điện tử với những đặc tính đã định sẵn ngay từ thang phân tử. Công nghệ nano là ngọn sóng thần kỹ nghệ đương đại mà những ứng dụng của nó đang dần dần xuất hiện, bùng nổ và sẽ tạo ra sức va đập mãnh liệt vào cuộc sống của xã hội loài người. Cốt lõi của nền công nghệ nano xoay quanh các phương thức chế biến những vật liệu nano, khảo sát hóa tính, lý tính, cơ tính, quang tính, điện tính, từ tính và tìm kiếm những ứng dụng cho các loại vật liệu này.");
        Picasso.with(getContext()).load("http://xspace.talaweb.com/nxbtrithuc/home/Khoa%20hoc%20va%20cong%20nghe%20nano.jpg").into(imvDetail);
    }

    private void addControl(View view) {
        tvName = view.findViewById(R.id.tvName);
        tvAuthor = view.findViewById(R.id.tvAuthor);
        tvPublisher = view.findViewById(R.id.tvPublisher);
        tvEdition = view.findViewById(R.id.tvEdition);
        tvTheme = view.findViewById(R.id.tvTheme);
        tvSumary = view.findViewById(R.id.tvSumary);
        imvDetail = view.findViewById(R.id.imvDetail);
        pbImv = view.findViewById(R.id.pbImageDetail);
    }
}

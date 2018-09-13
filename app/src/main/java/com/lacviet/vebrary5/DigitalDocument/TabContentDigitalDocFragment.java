package com.lacviet.vebrary5.DigitalDocument;

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
import android.widget.ScrollView;
import android.widget.TextView;

import com.lacviet.vebrary5.R;
import com.squareup.picasso.Picasso;

import static com.lacviet.vebrary5.MainActivityNew.toolbar;

public class TabContentDigitalDocFragment extends Fragment {
    TextView tvContent;
    //

    public TabContentDigitalDocFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_content_digitaldoc,container,false);
        addControl(view);
        tempData();
        return view;
    }



    private void tempData() {
       tvContent.setText("\" Như lai thần chưởng \" là môn tuyệt học võ công chấn danh thiên hạ.\n" +
               "\n" +
               "\" Như lai thần chưởng \" là môn tuyệt học võ công chấn danh thiên hạ ; truyền nhân đầu tiên của như lai thần chưởng chưởng pháp là Tà Thần - Vạn Bí Tà ; ông ta dựa vào môn chưởng pháp tuyệt thế này cùng với 5 võ lâm cao thủ khác nửa ; võ công có thể nói là đệ nhất thiên hạ lúc đó ; người ta thường xưng là \" Nhất tà - song phi - Tam tuyệt chưởng \" Vạn Bí Tà vốn là đệ nhất thiên hạ ; nhưng Tào Song phi và Tam tuyệt chương không phục ; nên đã bày mưu hãm hại ; nhưng tà thần mạng lớn ; chỉ bị tàn phế đôi chân và ẩn thân trong 1 cái hang nhỏ trên dốc núi ; vì có duyên nợ với nhau ; tà thần cứu được 1 thanh niên tên Long Thiên bị té xuống núi ; và nhận Long Thiên làm nghĩa tử và truyền lại toàn bộ thần chưởng ; Long Thiên kế thừa chưởng pháp trở thành truyền nhân đời thứ 2 của Như lai thần chưởng ; Để chữa khỏi bệnh cho nghĩa phụ ; Long Thiên tìm ra Tử long bí động ; và được tiểu kim long chữa khỏi đôi chân cho Tà thần ; ông không ngờ rằng có ngày mình lại có thể đứng lên được ; và rồi 2 cha con trở về trung nguyên thực hiện báo thù ; võ lâm đại loạn ; 6 đại cao thủ đại chiến ; trong hỗn chiến họ cũng tử trận ; không cam lòng khi nguy cơ thất truyền của NLTC ; tà thần đã lấy bí kíp cho vào bụng 1 con vượn ; rồi ông ôm con vượn đó cùng nhảy xuống vực thẳm ; từ đó trở đi chưởng pháp NLTC không thấy xuất hiện nửa...");
    }

    private void addControl(View view) {
        tvContent = view.findViewById(R.id.tvContent);
    }
}
package com.lacviet.vebrary5.DigitalDocument;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.lacviet.vebrary5.R;
import com.shockwave.pdfium.PdfDocument;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ReadPDFActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener,
        OnPageErrorListener {
    Toolbar toolbar;
    TextView tvTitleToolbar;

    PDFView pdfView;
    ProgressBar progressbar;
    //
    Integer pageNumber = 0;
    String pdfFileName;
    private static final String TAG = ReadPDFActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_pdf);
        addControl();
        actionBar();
        readPDFFromStream();
    }

    private void readPDFFromStream() {
        //new RetrivePDFStream().execute("http://ancestralauthor.com/download/sample.pdf");
        new RetrivePDFStream().execute("https://www3.nd.edu/~cpoellab/teaching/cse40816/android_tutorial.pdf");
    }

    private void readPDF() {
        Uri uri = Uri.parse("http://www3.nd.edu/~cpoellab/teaching/cse40816/android_tutorial.pdf");
        pdfView.fromUri(uri)
                /*.pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                // allows to draw something on the current page, usually visible in the middle of the screen
                .onDraw(onDrawListener)
                // allows to draw something on all pages, separately for every page. Called only for visible pages
                .onDrawAll(onDrawListener)
                .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
                .onPageChange(onPageChangeListener)
                .onPageScroll(onPageScrollListener)
                .onError(onErrorListener)
                .onPageError(onPageErrorListener)
                .onRender(onRenderListener) // called after document is rendered for the first time
                // called on single tap, return true if handled, false to toggle scroll handle visibility
                .onTap(onTapListener)
                .onLongPress(onLongPressListener)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
                .linkHandler(DefaultLinkHandler)
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(false) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode*/
                .load();
        progressbar.setVisibility(View.GONE);
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbarSearch);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        pdfView = findViewById(R.id.pdfView);
        progressbar = findViewById(R.id.progressbar);
    }
    private void actionBar() {
        setSupportActionBar(toolbar);
        tvTitleToolbar.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }
    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        Log.e(TAG, "title = " + meta.getTitle());
        Log.e(TAG, "author = " + meta.getAuthor());
        Log.e(TAG, "subject = " + meta.getSubject());
        Log.e(TAG, "keywords = " + meta.getKeywords());
        Log.e(TAG, "creator = " + meta.getCreator());
        Log.e(TAG, "producer = " + meta.getProducer());
        Log.e(TAG, "creationDate = " + meta.getCreationDate());
        Log.e(TAG, "modDate = " + meta.getModDate());

        printBookmarksTree(pdfView.getTableOfContents(), "-");
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }

    @Override
    public void onPageError(int page, Throwable t) {
        Log.e(TAG, "Cannot load page " + page);
    }

    class RetrivePDFStream extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            } catch (IOException e) {
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream)
                    .defaultPage(pageNumber)
                    .onPageChange(ReadPDFActivity.this)
                    .enableAnnotationRendering(true)
                    .onLoad(ReadPDFActivity.this)
                    .scrollHandle(new DefaultScrollHandle(ReadPDFActivity.this))
                    .spacing(10) // in dp
                    .onPageError(ReadPDFActivity.this)
                    .load();
            progressbar.setVisibility(View.GONE);
        }
    }
}
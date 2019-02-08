package com.r4sh33d.cgproject.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.r4sh33d.cgproject.ColorUtil;
import com.r4sh33d.cgproject.ElementType;
import com.r4sh33d.cgproject.R;
import com.r4sh33d.cgproject.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class BasicPrimitiveFragment extends BaseFragment implements ColorChooserDialog.ColorCallback{
    @BindView(R.id.triangle_type_card_view_layout)
    CardView trianglesCardView;

    @BindView(R.id.vertices_card_view_layout)
    CardView verticesCardView;

    @BindView(R.id.animate_check_box)
    AppCompatCheckBox animateCheckBox;

    @BindView(R.id.color_image_view)
    ImageView colorImageView;

    private String elementDetails = "";
    private String pageTitle = "";
    private String toolbarTitle = "";
    float polygonCoords[];
    String detailsDialogTitle = "";

    float colorPicked[] = {0.0f, 0.0f, 1.0f, 1.0f};

    ElementType elementType;


    private static final String ELEMENT_TYPE_KEY = "element_type_key";

    public static BasicPrimitiveFragment newInstance (ElementType elementType) {
        Bundle args = new Bundle();
        args.putSerializable(ELEMENT_TYPE_KEY, elementType);
        BasicPrimitiveFragment fragment = new BasicPrimitiveFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public BasicPrimitiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic_primitive, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        elementType = (ElementType) getArguments().getSerializable(ELEMENT_TYPE_KEY);
        colorImageView.setBackgroundColor(Color.BLUE);
        configureScreen();
        showDetails();
    }

    @OnClick(R.id.color_card_view_layout)
    public void onClickColorCardViewLayout(){
        new ColorChooserDialog.Builder(getActivity(), R.string.color)
                .titleSub(R.string.color)
                .accentMode(false)
                .doneButton(R.string.done)
                .cancelButton(R.string.cancel)
                .backButton(R.string.back)
                .preselect(Color.BLUE)
                .dynamicButtonColor(false)
                .show(getChildFragmentManager());
    }

    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, int selectedColor) {
           colorImageView.setBackgroundColor(selectedColor);
           colorPicked = ColorUtil.getColorArray(selectedColor);
    }


    @OnClick(R.id.draw_button)
    public void onClickDrawButton(){

    }


    @Override
    public void onColorChooserDismissed(@NonNull ColorChooserDialog dialog) {

    }

    public void showDetails(){
        new MaterialDialog.Builder(getContext())
                .title(toolbarTitle)
                .content(elementDetails)
                .positiveText("Okay")
                .onPositive((dialog, which) -> dialog.dismiss())
                .show();
    };


    public void configureScreen() {
        switch (elementType) {
            case POINTS:
                ViewUtils.show(verticesCardView);
                toolbarTitle = "GL POINT";
                pageTitle = "Configure the GL POINT";
                elementDetails = "A point is represented by a set of floating-point numbers called a vertex. " +
                        "All internal calculations are done as if vertices are three-dimensional. Vertices specified" +
                        " by the user as two-dimensional (that is, with only x- and y-coordinates) are assigned a " +
                        "z-coordinate equal to zero by OpenGL.";
                break;

            case LINES:
                ViewUtils.show(verticesCardView);
                toolbarTitle = "GL LINE";
                pageTitle = "Configure the GL LINE";
                elementDetails = "In OpenGL, the term line refers to a line segment, not the mathematician’s version that " +
                        "extends to infinity in both directions. There are easy ways to specify a connected series of line " +
                        "segments, or even a closed, connected series of segments (see Figure 2-2). In all cases, though," +
                        " the lines constituting the connected series are specified " +
                        "in terms of the vertices at their endpoints.";
                break;

            case TRIANGLES:
                toolbarTitle = "GL TRIANGLE";
                pageTitle = "Configure the GL TRIANGLE";
                elementDetails = "A triangle is a polygon with three edges and three vertices." +
                        " It is one of the basic shapes in geometry. A triangle with vertices A, B, and C is denoted." +
                        " In Euclidean geometry any three points, when non-collinear, determine a unique triangle and simultaneously, " +
                        "a unique plane (i.e. a two-dimensional Euclidean space).";
                break;

            case RECTANGLES:
                elementDetails = "In Euclidean plane geometry, a rectangle is a quadrilateral with four right angles. " +
                        "It can also be defined as an equiangular quadrilateral, since equiangular means that all of its " +
                        "angles are equal (360°/4 = 90°)." +
                        " It can also be defined as a parallelogram containing a right angle.";
                toolbarTitle = "GL RECTANGLE";
                pageTitle = "Configure the GL RECTANGLE";
                break;

            case POLYGONS:
                ViewUtils.show(verticesCardView);
                toolbarTitle = "GL POLYGON";
                pageTitle = "Configure the GL POLYGON";
                elementDetails = "Polygons are the areas enclosed by single closed loops of line segments, " +
                        "where the line segments are specified by the vertices at their endpoints. Polygons are " +
                        "typically drawn with the pixels in the interior filled in, but you can also draw them as " +
                        "outlines or a set of points. (See “Polygon Details” on page 60.)";
                break;
        }
    }
}

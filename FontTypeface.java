package com.gordonlu.fonttypeface;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

import android.widget.TextView;
import android.view.View;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import android.view.Gravity;
import android.graphics.Typeface;

@DesignerComponent(
        version = 1,
        description = "A non-visible extension that sets the font typeface of visible components dynamically.",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "https://docs.google.com/drawings/d/e/2PACX-1vQCI87PHLBF0jb8QWyYmIRQSjjNW3EFXf-qpsWCvBYkUQ9vEgPAB8SpxcMpblxNpbIYrjCjLrRLIU2c/pub?w=16&h=16")

@SimpleObject(external = true)
//Libraries
@UsesLibraries(libraries = "")
//Permissions
@UsesPermissions(permissionNames = "")

public class FontTypeface extends AndroidNonvisibleComponent {

    //Activity and Context
    private Context context;
    private Activity activity;

    public FontTypeface(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleProperty(description = "A font block.")
    public String DefaultFont() {
        return "DEFAULT";
    }
    @SimpleProperty(description = "A font block.")
    public String Serif() {
        return "SERIF";
    }
    @SimpleProperty(description = "A font block.")
    public String SansSerif() {
        return "SANS SERIF";
    }
    @SimpleProperty(description = "A font block.")
    public String Monospace() {
        return "MONOSPACE";
    }
    @SimpleFunction(description = "Sets the font typeface of the TextBox, including whether to bold, italicize, and the font of the TextBox." + 
    " Use the blocks in the properties of this extension for the font parameter." + 
    " If useCurrentFont is true, the font parameter will be ignored.")
    public void SetFontTypeface(AndroidViewComponent component, boolean bold, boolean italic, String font, boolean useCurrentFont) {
        Typeface t = Typeface.DEFAULT;
        View view = component.getView();
        TextView tv = (TextView) view;
        if (useCurrentFont) {
        t = tv.getTypeface();
        } else {
        if (font == "DEFAULT") {
            t = Typeface.DEFAULT;
        } else if (font == "SERIF") {
            t = Typeface.SERIF;
        } else if (font == "SANS SERIF") {
            t = Typeface.SANS_SERIF;
        } else if (font == "MONOSPACE") {
            t = Typeface.MONOSPACE;
        }
        }
        if (bold && italic) {
            tv.setTypeface(t, Typeface.BOLD_ITALIC);
        } else if (bold && !italic) {
            tv.setTypeface(t, Typeface.BOLD);
        } else if (italic && !bold) {
            tv.setTypeface(t, Typeface.ITALIC);
        } else {
            tv.setTypeface(t, Typeface.NORMAL);
        }
    }
}

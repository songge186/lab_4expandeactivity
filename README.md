# lab_4expandeactivity
实验四: 扩展的Activity

一、实验内容

1、使用PrefereceFragment实现设置页面

基本要求：实现如下两个图拼接而成的设置界面
![](https://github.com/jinrongrong815/img_folder/raw/master/Lab_4_1q.png)
二、关键代码

1、

MainActivity.java

public class MainActivity extends AppCompatActivity {

private static final int menu_setting = 1;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    android.app.FragmentManager frangmentManager = getFragmentManager();
    android.app.FragmentTransaction transaction = frangmentManager.beginTransaction();
    PreFragment preFragment = new PreFragment();

    transaction.replace(android.R.id.content, preFragment).addToBackStack(null);
    transaction.commit();
}
}

PreFragment.java

public class PreFragment extends PreferenceFragment {

@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //从xml文件中加载选项
    addPreferencesFromResource(R.xml.preferences);
}
}
preferences.xml

<PreferenceCategory
    android:title="@string/pref_list_storage_title"
    android:key="pref_key_storage_dialog_settings">
    <EditTextPreference
        android:key="edit_text"
        android:title="Edit text preference"
        android:dialogTitle="Enter your favorite animal"
        android:summary="An example that usea an edit text dialog">
    </EditTextPreference>
    <ListPreference
        android:key="list_preference_key"
        android:summary="@string/pref_list_summ"
        android:title="@string/pref_list_title"
        android:dialogTitle="@string/pref_dialog_title"
        android:entries="@array/pref_syncConnectionTypes_entries"
        android:entryValues="@array/pref_syncConnectionTypes_values"
        android:defaultValue="@string/pref_syncConnectionTypes_entries" />
</PreferenceCategory>

<PreferenceCategory
    android:title="@string/pref_launch_storage_title"
    android:key="pref_key_storage_launch_settings">
    <PreferenceScreen
        android:key="button_voicemail_category_key"
        android:title="@string/pref_screen_title"
        android:summary="@string/pref_screen_summ"
        android:persistent="false">
        <CheckBoxPreference
            android:key="screen_check_box_key"
            android:title="@string/pref_screen_checkbox_title"
            android:summary="@string/pref_screen_checkbox_summ"
            android:defaultValue="false" />
    </PreferenceScreen>
    <Preference android:title="Intent preference"
        android:summary="Launches an Activity from an Intent">
        <intent android:action="android.intent.action.VIEW"
            android:data="http://www.example.com" />
    </Preference>
</PreferenceCategory>
<PreferenceCategory
    android:title="Preference attribute"
    android:key="pref_key_storage_attribute_settings">
    <CheckBoxPreference
        android:key="check_box_key1"
        android:title="Parent checkbox preference"
        android:summary="This is visually a parent"
        android:defaultValue="false" />
    <CheckBoxPreference
        android:key="check_box_key2"
        android:dependency="check_box_key1"
        android:title="Child checkbox preference"
        android:summary="This is visually a child"
        android:defaultValue="false" />
</PreferenceCategory>
三、实验结果截图
!'[](https://github.com/jinrongrong815/img_folder/raw/master/Lab_4_1a.png)
![](https://github.com/jinrongrong815/img_folder/raw/master/Lab_4_2a.png)
![](https://github.com/jinrongrong815/img_folder/raw/master/Lan_4_3a.png)

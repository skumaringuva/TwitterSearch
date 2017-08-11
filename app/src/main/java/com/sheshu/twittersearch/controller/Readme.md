# TwitterSearch TwitterSearch is a simple twitter search application.

# How to Build
For building the app you need Twitter app key and secret. save them in a file app_settings.properties and place it in $home/my_settings/app_settings.properties
```
consumer_key=HHHHHHHHH39893485983495893485
consumer_secret=KKKKKKKKKKKKKKKKKKAHDFJKHADJKFHJKAHDFO8UQIOERUIOQUWERIO
```
Then in the gradle.properties of android define this settings file
```
MyProject.settings=//Users/Sheshu/my_settings/app_settings.properties
```
These settings will be mapped to BuildConfig in the app/build.gradle . And will be pickedup by the contstants in com.sheshu.twittersearch.controller.TwitterController.AuthenticationAsyncTask
# Build
Just build and it will download the required dependencies. First build would take some time.

# Run
Its a normal SearchView in toolbar with a listview

# Video

# Features
[*] Authentication with consumer key.
[*] Search using Retrofit
[*] Render search results in a RecyclerView using CardView.



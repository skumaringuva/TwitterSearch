# TwitterSearch TwitterSearch is a simple twitter search application.


# Features
* [*] Authentication with consumer key.
* [*] Search using Retrofit
* [*] Render search results in a RecyclerView using CardView.
* [*] Download profile pics using Picasso.

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


## Video Walkthrough

This is demo gif:

<img src='https://github.com/skumaringuva/TwitterSearch/blob/master/TwitterSearch.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).


## License

    MIT License

Copyright (c) 2017 SheshuKumar Inguva

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.



# Lower-Thirds-SDV
Stage display viewer in java for propresenter.

The output text is shown in a lower key fashion, i.e. it's shown in the lower part of the screen. It also compactifies rows by removing every second line break, i.e. 4 rows will be shown as 2 rows.

It should work in Windows/MacOS/Linux and other *nix systems

## Known Issues
* Propresenter 5 for Windows does not support UTF-8 correctly which makes international characters to be shown incorrectly, e.g. Swedish characters ÅÄÖ are shown as ???. This is fixed in propresenter 6.


## Changelog

6.27.18
* Added applicationSettings
* Added OS check to applicationSettings
* Added setIcon to applicationSettings
* Added .icns to Images Folder for Exporting
* Program now sets icon image based on OS
* Added a couple new JFrame’s for Lyrics
* Added Back button on several JFrames
* Added .dispose() instead of hiding the JFrame to free up resources

6.27.18
------------------------------------------------------------------------------------------------------------
* Added “Show Password” checkbox on Login screen
* Released a patch to fix needing to decompile the Jar to get it to run Properly

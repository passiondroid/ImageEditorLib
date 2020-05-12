# ImageEditorLib

A minimal image editor library for Android. Similar to what WhatsApp offers for image editing.

## Demo
<img src="demo.gif" width="250">

## Installation

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


Add the dependency in build.gradle for app module

	dependencies {
	        implementation 'com.github.passiondroid:ImageEditorLib:1.0.2'
	}

## Usage

Call `ImageEditor.Builder` to start editing the image as below
```
ImageEditor.Builder(this, YOUR_IMAGE_PATH).open()
```

Receive the edited image in your activity as below
```
 override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            ImageEditor.RC_IMAGE_EDITOR ->
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val imagePath: String = data.getStringExtra(ImageEditor.EXTRA_EDITED_PATH)
                    edited_image.setImageBitmap(BitmapFactory.decodeFile(imagePath))
                }
        }
    }
```

Make sure your app has permissions to read and write to external storage.

*Can be improved by using internal storage provided to the app. PR's are welcome.*

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
[MIT](https://choosealicense.com/licenses/mit/)

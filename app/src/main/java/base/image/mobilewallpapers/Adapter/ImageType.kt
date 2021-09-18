package base.image.mobilewallpapers.Adapter

enum class ImageType {

    RANDOM,
    RECENT,
    POPULAR;

    companion object{
        fun getPathName(imageType: ImageType):String{
            return when(imageType){
                RANDOM -> "Random"
                RECENT -> "Recent"
                POPULAR -> "Popular"
            }
        }
    }
}
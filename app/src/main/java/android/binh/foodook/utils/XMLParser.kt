package android.binh.foodook.utils

import android.binh.foodook.base.BaseModel
import android.binh.foodook.models.food.Food
import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import java.io.StringReader

class XMLParser : IDataParser {

    override fun parseFood(string: String): MutableList<Food> {
        val items : MutableList<Food> = ArrayList<Food>()
        var isItem : Boolean = false
        var title : String? = ""
        var desc : String? = ""
        var image : String? = ""
        var link : String? = ""
        var date : String? = ""

        val xmlPullParser : XmlPullParser = Xml.newPullParser()
        xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
        xmlPullParser.setInput(StringReader(string))

        xmlPullParser.nextTag()

        while (xmlPullParser.next() != XmlPullParser.END_DOCUMENT) {
            val eventType = xmlPullParser.eventType
            val name = xmlPullParser.name ?: continue

            if (eventType == XmlPullParser.END_TAG) {
                if (name == "item") {
                    isItem = false
                }
                continue
            }

            if (eventType == XmlPullParser.START_TAG) {
                if (name == "item") {
                    isItem = true
                    continue
                }
            }

            var result = ""
            if (xmlPullParser.next() == XmlPullParser.TEXT) {
                result = xmlPullParser.text
                xmlPullParser.nextTag()
            } else if (name.equals("enclosure", true)){
                result = xmlPullParser.getAttributeValue(null, "url")
            }

            when {
                name.equals("title", true) -> title = result
                name.equals("link", true) -> link = result
                name.equals("description", true) -> desc = result
                name.equals("pubDate", true) -> date = result
                name.equals("enclosure", true) -> image = result
            }

            if (title != null && link != null && desc != null && date != null && image != null) {
                if (isItem) {
                    val it = Food(image, title, date, 5)
                    items.add(it)
                }
                title = null
                link = null
                desc = null
                date = null
                image = null
            }
        }

        return items
    }
}
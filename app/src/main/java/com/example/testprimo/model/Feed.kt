package com.example.testprimo.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
class Feed (
    @field: Element(name = "channel")
    var channel: FeedChannel? = null
)

@Root(name = "channel", strict = false)
class FeedChannel (
    @field: ElementList(inline = true)
    var itemList: List<FeedItem>? = null
)

@Root(name = "item", strict = false)
class FeedItem (
    @field: Element(name = "title")
    var title: String = "",
    @field: Element(name = "description", required = false)
    var description: String = "",
    @field: Element(name = "link")
    var link: String = "",
    @field: Element(name = "pubDate",  required = false)
    var pubDate: String = "",
    @field: Element(name = "content", required = false)
    var encodedContent: String? = null
)

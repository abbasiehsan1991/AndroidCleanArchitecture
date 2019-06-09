package codenevisha.com.cleanarchitecture.domain.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class ArticleModel(
    @SerializedName("status") var status: String?,
    @SerializedName("totalResults") var totalResults: Int?,
    @SerializedName("articles") var articles: MutableList<Article>?
) {
    constructor() : this(null, null, null)
}

@Entity
@Parcelize
data class Article(

    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @SerializedName("author") var author: String?,
    @SerializedName("title") var title: String = "No Title",
    @SerializedName("description") var description: String ="No Description",
    @SerializedName("url") var url: String?,
    @SerializedName("urlToImage") var urlToImage: String?,
    @SerializedName("publishedAt") var publishedAt: String?,
    @SerializedName("content") var content: String?,
    @Embedded
    @SerializedName("source") var source: Source

) : Parcelable {
    var atricleAuthor = "Author: $author"
}

@Parcelize
class Source constructor(
    @SerializedName("id") var sourceId: String?,
    @SerializedName("name") var sourceNname: String?
) : Parcelable

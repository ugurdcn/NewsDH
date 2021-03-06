package com.zeygame.newsdh.model


data class Data(var Awards: List<Any>,
                var Category: Category,
                var ColorAvarage: String,
                var CommentCount: Int,
                var ContentList: List<ContentList>,
                var CreateDate: Int,
                var DateWellFormed: String,
                var Duration: String,
                var EditorColor: String,
                var EditorsChooseMessageId: Int,
                var FavoriteCount: Int,
                var GalleryDateWellFormed: String,
                var GalleryId: Int,
                var GalleryTotalRead: Int,
                 var Id: Int,
                var Image: Image,
                var ImageCount: Int,
      //    val Images: List<ImageX>,
                var IsFavorite: Int,
                var IsLocked: Int,
                var Member: Member,
                var MyReputation: Boolean,
                var OnlineUser: Int,
                var RelatedNews: List<RelatedNew>,
                var ShareCount: Int,
                var ShortContent: String,
                var SourceUrl: String,
                var SubTextColor: String,
                var SurveyId: Int,
                val TextColor: String,
                var ThreadId: Int,
                var Title: String,
                var TotalComment: Int,
                var TotalRead: Int,
                var TotalReputation: Int,
                var Type: Int,
                var Url: String
                 ){

     fun converToNews(isFavorite:Boolean):News{
         return News(Id,Image.Value,ShortContent, Title,Url,isFavorite)
     }
 }
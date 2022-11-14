package com.example.movie_review.jdbc;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContentsDao {
    @Select("select * from content")
    List<ContentDTO> list();

    @Select("select @rownum:= @rownum+1 as #{rownum}, * from content order by num desc where (@rownum:= 0)=0")
    List<ContentDTO> list2();
//    String sql = "select @rownum:= @rownum+1 as rownum, a.* from " +
//            "(select cid, ctitle, cdate, mid, tname from cboard order by cid desc) a where (@rownum:= 0)=0";

    @Insert("insert into content (movie,title,review,writer) values( #{movie}, #{title}, #{review}, #{writer})")
    int insert(String movie,String title, String review, String writer);

    @Select("select num, movie, title, writer, review from content where title = #{title}")
    List<ContentDTO> review(String title);
}

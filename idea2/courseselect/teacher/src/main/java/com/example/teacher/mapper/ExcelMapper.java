package com.example.teacher.mapper;

import com.example.common.pojo.Excel;
import com.example.common.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ExcelMapper {
//    @Select("select *,a.author_name from author a,musicmant m where m.music_author_id=a.author_id and m.music_status=1 and music_type=${type} ")
//    @Results({
//            @Result(property = "music_id", column = "music_id"),
//            @Result(property = "music_name", column = "music_name"),
//            @Result(property = "music_image", column = "music_image"),
//            @Result(property = "music_music", column = "music_music"),
//            @Result(property = "author.author_name", column = "author_name"),
//    })
//    List<Excel> musicyuke(Integer type);

      @Select("select sno,name,college_name,grade,class_name,remark from student")
      List<Excel>list();
}

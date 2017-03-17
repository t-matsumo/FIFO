package fifo.controller.contents.exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fifo.entity.ExerciseEnglish;
import fifo.repository.ExerciseEnglishRepository;

@Controller
@RequestMapping(value = "/exercises/english")
public class EnglishController {
  @Autowired
  ExerciseEnglishRepository exerciseEnglishRepository;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String exercise(@PathVariable("id") Long id, Model model) {
    // データベースに問題を入れてから有効化
    // ExerciseEnglish exercise = exerciseEnglishRepository.findOne(id);

    model.addAttribute("id", id);
    // model.addAttribute("exercise", exercise);

    return "contents/exercises/exercise";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public String answer(@PathVariable("id") Long id, Model model) {
    // データベースに問題を入れてから有効化
    // ExerciseEnglish exercise = exerciseEnglishRepository.findOne(id);

    // TODO:回答との比較処理を書く
    String result = "正解 or 不正解";

    model.addAttribute("id"      , id);
    // model.addAttribute("exercise", exercise);
    model.addAttribute("result"  , result);
    
    // 答え合わせと次へボタンを返す
    return "contents/exercises/answer";
  }

  @RequestMapping(value = "/result", method = RequestMethod.GET)
  public String result() {
    // データベースから結果を取ってきて表示
    return "contents/exercises/result";
  }
}
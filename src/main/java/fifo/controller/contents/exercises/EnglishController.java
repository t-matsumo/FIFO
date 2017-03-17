package fifo.controller.contents.exercises;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/exercises/english")
public class EnglishController {
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String exercise(@PathVariable("id") String id, Model model) {
    // 問題をデータベースから取ってくる
    model.addAttribute("id", id);
    
    // 問題文と解答フォームを返す

    // CAUTION:最後の問題のときは結果表示画面を返す！！！（永遠に終わらせないなら良いけどwww）

    return "contents/exercises/exercise";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public String answer(@PathVariable("id") String id, Model model) {
    // 答えをデータベースから取ってきて比較
    model.addAttribute("id", id);
    model.addAttribute("nextId", Long.parseLong(id) + 1L);
    
    // 答え合わせと次へボタンを返す
    return "contents/exercises/answer";
  }

  @RequestMapping(value = "/result", method = RequestMethod.GET)
  public String result() {
    // データベースから結果を取ってきて表示

    return "contents/exercises/result";
  }
}
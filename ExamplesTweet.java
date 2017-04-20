import tester.*;

class User {

}

class DateTime {

}

class TextTweet {
  String toHTML() {
    return "<div id='tweet'>" + "content might go here, for example" + "</div>";
  }
}

class ImageTweet {

}

class ExamplesTweet {
  TextTweet t = new TextTweet();  

  String htmlTweet1 = t.toHTML();
}

import 'Story.dart';

class Stories {
  String title;
  List<Story> stories;

  Stories(this.title, this.stories);

  factory Stories.fromJson(Map<String, dynamic> json) {
    var storiesList = json['object_stories'] as List;
    List<Story> stories = storiesList.map((i) => Story.fromJson(i)).toList();

    return Stories(json['title_story'] ?? '', stories);
  }
}

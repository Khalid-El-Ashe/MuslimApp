class Story {
  int id;
  String name;
  String content;
  String youtube_url;

  Story(this.id,this.name, this.content, this.youtube_url);

  factory Story.fromJson(Map<String, dynamic> json) {
    return Story(
      json['id'] ?? 0,
      json['name'] ?? '',
      json['content'] ?? '',
      json['youtube_url'] ?? '',
    );
  }
}
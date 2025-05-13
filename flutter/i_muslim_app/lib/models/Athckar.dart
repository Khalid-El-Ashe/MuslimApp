import 'dart:ffi';

class Athckar {
  int id;
  String name;
  String content;
  String youtube_url;

  Athckar(this.id,this.name, this.content, this.youtube_url);

  factory Athckar.fromJson(Map<String, dynamic> json) {
    return Athckar(
      json['id'] ?? 0,
      json['name'] ?? '',
      json['content'] ?? '',
      json['youtube_url'] ?? '',
    );
  }
}
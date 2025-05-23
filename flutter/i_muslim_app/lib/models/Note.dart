import 'package:hive/hive.dart';
part 'Note.g.dart';

@HiveType(typeId: 0)
class Note extends HiveObject {
  @HiveField(0)
  String title;

  @HiveField(1)
  String content;

  @HiveField(2)
  DateTime createdAt;

  Note({required this.title, required this.content, DateTime? createdAt})
    : createdAt = createdAt ?? DateTime.now();
}

import 'package:hive/hive.dart';

import '../../../models/Note.dart';

class HiveBuilder {
  static late final Box<Note> noteBox;

  static Future<void> init() async {
    noteBox = Hive.box<Note>('notes');
  }

  static Future<void> addNote(String title, String content) async {
    if (!noteBox.isOpen) {
      throw Exception('Hive box is not open');
    } else {
      final note = Note(title: title, content: content);
      await noteBox.add(note);
      print('HiveBuilder: note added ${note.title}');
    }
  }

  static Future<void> deleteNote(int index) async {
    if (!noteBox.isOpen) return;
    await noteBox.deleteAt(index);
  }

  static Future<void> updateNote(
    int index,
    String title,
    String content,
  ) async {
    if (!noteBox.isOpen) return;
    final note = noteBox.getAt(index);
    if (note != null) {
      note.title = title;
      note.content = content;
      await note.save(); //
    }
  }

  static List<Note> getNotes() {
    if (!noteBox.isOpen) return [];
    return noteBox.values.toList();
  }
}

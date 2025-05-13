import 'package:flutter/material.dart';
import 'package:hive_flutter/adapters.dart';
import 'package:i_muslim_app/models/ColorSelect.dart';
import 'package:i_muslim_app/ui/widget/custom_app_bar_widget.dart';
import 'package:waterfall_flow/waterfall_flow.dart';

import '../../../models/Note.dart';
import 'hive_builder.dart';
import 'note_form_screen.dart';

class NotesScreen extends StatefulWidget {
  const NotesScreen({super.key});

  @override
  State<NotesScreen> createState() => _NotesScreenState();
}

class _NotesScreenState extends State<NotesScreen> {
  List<Note> notes = [];

  void loadNotes() {
    setState(() {
      notes = HiveBuilder.getNotes();
    });
  }

  @override
  void initState() {
    super.initState();
    loadNotes();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: CustomAppBar(title: 'Notes'),
      body: ValueListenableBuilder(
        valueListenable: HiveBuilder.noteBox.listenable(),
        builder: (context, Box<Note> box, widget) {
          if (box.isEmpty) {
            return const Center(child: Text('no notes yet'));
          } else {
            return Padding(
              padding: const EdgeInsets.all(8.0),
              child: WaterfallFlow.builder(
                gridDelegate:
                    SliverWaterfallFlowDelegateWithFixedCrossAxisCount(
                      crossAxisCount: 2,
                      crossAxisSpacing: 8,
                      mainAxisSpacing: 8,
                    ),
                itemCount: box.values.length,
                itemBuilder: (context, index) {
                  final note = box.getAt(index);
                  return Card(
                    color: Colors.yellow[100],
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(12),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(12.0),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            note!.title,
                            style: const TextStyle(fontWeight: FontWeight.bold),
                          ),
                          const SizedBox(height: 8),
                          Text(note.content),
                          const SizedBox(height: 8),
                          Text(
                            note.createdAt.toString(),
                            style: const TextStyle(
                              fontSize: 12,
                              color: Colors.grey,
                            ),
                          ),
                        ],
                      ),
                    ),
                  );
                },
              ),
            );
          }
        },
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: ColorSelect.primary,
        child: const Icon(Icons.add, color: Colors.white),
        onPressed: () {
          Navigator.of(context).push(
            MaterialPageRoute(builder: (context) => const NoteFormScreen()),
          );
        },
      ),
    );
  }
}

import 'package:flutter/material.dart';
import 'package:i_muslim_app/ui/screen/notes/hive_builder.dart';
import 'package:i_muslim_app/ui/widget/custom_app_bar_widget.dart';

class NoteFormScreen extends StatefulWidget {
  const NoteFormScreen({super.key});

  @override
  State<NoteFormScreen> createState() => _NoteFormScreenState();
}

class _NoteFormScreenState extends State<NoteFormScreen> {
  final TextEditingController _titleController = TextEditingController();
  final TextEditingController _contentController = TextEditingController();

  final _noteFormKey = GlobalKey<FormState>();

  // this function to validate the data
  String? _fieldValidator(String? value) {
    if (value == null || value.isEmpty) {
      return 'Please enter a value';
    }
    return null;
  }

  Future<void> _addNote() async {
    if (_noteFormKey.currentState!.validate()) {
      await HiveBuilder.addNote(
        _titleController.text.trim(),
        _contentController.text.trim(),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: CustomAppBar(
        title: 'Add Note',
        actions: [
          IconButton(
            onPressed: () async {
              await _addNote();
              Navigator.pop(context);
            },
            icon: Icon(Icons.check, color: Colors.white),
          ),
        ],
      ),

      body: Form(
        key: _noteFormKey,
        child: Padding(
          padding: const EdgeInsets.all(10),
          child: Column(
            children: [
              TextFormField(
                controller: _titleController,
                validator: _fieldValidator,
                decoration: const InputDecoration(
                  labelText: 'Title',
                  hintText: 'Enter your title',
                ),
              ),
              const SizedBox(height: 20),
              TextFormField(
                controller: _contentController,
                validator: _fieldValidator,
                decoration: const InputDecoration(
                  labelText: 'Content',
                  hintText: 'Enter your content',
                ),
                maxLines: 5,
              ),
            ],
          ),
        ),
      ),
    );
  }
}

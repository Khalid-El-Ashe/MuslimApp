import 'package:flutter/material.dart';
import 'package:hive/hive.dart';
import 'package:hive_flutter/adapters.dart';
import 'package:i_muslim_app/models/Note.dart';
import 'package:i_muslim_app/ui/screen/home_screen.dart';
import 'package:i_muslim_app/ui/screen/notes/hive_builder.dart';

void main() async {
  // i need to enable the hive dependency to save the data in the local storage
  WidgetsFlutterBinding.ensureInitialized();
  await Hive.initFlutter();
  Hive.registerAdapter(NoteAdapter());
  await Hive.openBox<Note>('notes');
  await HiveBuilder.init(); // to init the hive builder to can get the functions

  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return SafeArea(child: MaterialApp(home: const HomeScreen()));
  }
}

import 'package:flutter/material.dart';
import 'package:i_muslim_app/models/Athckar.dart';
import 'package:i_muslim_app/models/ColorSelect.dart';
import 'package:i_muslim_app/network/api_service.dart';
import 'package:i_muslim_app/ui/screen/stories/stories_screen.dart';
import 'package:i_muslim_app/ui/widget/custom_app_bar_widget.dart';
import 'package:i_muslim_app/ui/widget/custom_category_card_widget.dart';

import 'details_screen.dart';
import 'more_screen.dart';
import 'notes/notes_screen.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  List<Athckar> _athckar = [];

  void loadData() async {
    final data = await ApiService().fetchAthckarData();
    setState(() {
      _athckar = data;
    });
  }

  @override
  void initState() {
    super.initState();
    loadData();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: CustomAppBar(
        title: 'Home',
        actions: [
          IconButton(
            icon: const Icon(Icons.edit_note, color: Colors.white),
            tooltip: '',
            onPressed: () async {
              Navigator.of(context).push(
                MaterialPageRoute(builder: (context) => const NotesScreen()),
              );
            },
          ),
        ]
      ),
      body: SafeArea(
        child: Center(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              SizedBox(height: 40),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  CategoryCardWidget(
                    title: "morning",
                    imagePath: "assets/images/ic_morning.png",
                    onClick: () {
                      for (var morningData in _athckar) {
                        if (morningData.id == 0) {
                          Navigator.of(context).push(
                            MaterialPageRoute(
                              builder:
                                  (context) => DetailsScreen(
                                    title: morningData.name,
                                    content: morningData.content,
                                    youtube_url: morningData.youtube_url,
                                  ),
                            ),
                          );
                        }
                      }
                    },
                  ),
                  SizedBox(width: 20),
                  CategoryCardWidget(
                    title: "evening",
                    imagePath: "assets/images/ic_evening.png",
                    onClick: () {
                      for (var eveiningData in _athckar) {
                        if (eveiningData.id == 1) {
                          Navigator.of(context).push(
                            MaterialPageRoute(
                              builder:
                                  (context) => DetailsScreen(
                                    title: eveiningData.name,
                                    content: eveiningData.content,
                                    youtube_url: eveiningData.youtube_url,
                                  ),
                            ),
                          );
                        }
                      }
                    },
                  ),
                ],
              ),

              SizedBox(height: 40),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  CategoryCardWidget(
                    title: "Stories",
                    imagePath: "assets/images/ic_stories.png",
                    onClick: () {
                        Navigator.of(context).push(MaterialPageRoute(builder: (context) => const StoriesScreen()));
                    },
                  ),
                  SizedBox(width: 20),
                  CategoryCardWidget(
                    title: "title",
                    imagePath: "assets/images/ic_about.png",
                    onClick: () {
                      print('clicked on card');
                    },
                  ),
                ],
              ),

              SizedBox(height: 40),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  CategoryCardWidget(
                    title: "title",
                    imagePath: "assets/images/ic_allah.png",
                    onClick: () {
                      print('clicked on card');
                    },
                  ),
                  SizedBox(width: 20),
                  CategoryCardWidget(
                    title: "title",
                    imagePath: "assets/images/ic_prayer.png",
                    onClick: () {
                      print('clicked on card');
                    },
                  ),
                ],
              ),

              SizedBox(height: 20),
              SizedBox(
                width: 340,
                height: 50,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: ColorSelect.primary,
                  ),
                  onPressed: () {
                    Navigator.of(context).push(
                      MaterialPageRoute(
                        builder: (context) => const MoreScreen(),
                      ),
                    );
                  },
                  child: Text(
                    "More",
                    style: TextStyle(color: Colors.white, fontSize: 16),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

import '../widget/custom_app_bar_widget.dart';

class DetailsScreen extends StatelessWidget {
  final String title;
  final String content;
  final String youtube_url;

  const DetailsScreen({
    super.key,
    required this.title,
    required this.content,
    required this.youtube_url,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: CustomAppBar(
        title: title,
        actions: [
          IconButton(
            icon: const Icon(Icons.headphones, color: Colors.white),
            tooltip: '',
            onPressed: () async {
              final url = Uri.parse(youtube_url);
              print('the youtube url: $url');

              if (await canLaunchUrl(url)) {
                await launchUrl(url, mode: LaunchMode.externalApplication);
              } else {
                throw 'Could not launch $url';
              }
              // print('youtube url: $url_youtube');
            },
          ),

          IconButton(
            onPressed: () {

            },
            icon: const Icon(
              Icons.slow_motion_video_outlined,
              color: Colors.white,
            ),
          ),
        ],
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Container(
            width: double.infinity,
            height: 700,
            padding: EdgeInsets.only(top: 20, left: 10, right: 10, bottom: 0),
            // margin: EdgeInsets.only(left: 10, right: 10),
            decoration: BoxDecoration(
              // color: ColorSelect.cardTitleBackground,
              borderRadius: BorderRadius.only(
                bottomLeft: Radius.circular(20),
                bottomRight: Radius.circular(20),
              ),
              // boxShadow: [
              //   BoxShadow(
              //     color: Colors.grey.withOpacity(0.5),
              //     spreadRadius: 5,
              //     blurRadius: 7,
              //     offset: Offset(0, 3),
              //   ),
              // ],
            ),
            child: SingleChildScrollView(
              child: Text(
                content,
                style: TextStyle(
                  color: Colors.black,
                  fontSize: 18,
                  fontFamily: 'Cairo',
                ),
                textAlign: TextAlign.right,
              ),
            ),
          ),
        ],
      ),
    );
  }
}

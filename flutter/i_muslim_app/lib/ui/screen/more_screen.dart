import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../widget/custom_app_bar_widget.dart';

class MoreScreen extends StatefulWidget {
  const MoreScreen({super.key});

  @override
  State<MoreScreen> createState() => _MoreScreenState();
}

class _MoreScreenState extends State<MoreScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: CustomAppBar(title: 'More'),
      body: SafeArea(child: Center(
        child: Text('More Screen', style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold)),
      )),
    );
  }
}

import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:i_muslim_app/models/Constance.dart';
import 'package:i_muslim_app/models/Stoies.dart';

import '../models/Athckar.dart';
import '../models/Result.dart';

// this class is with class Result
class HttpData {
  static Future<Result<List<Athckar>>> loadAthckarData() async {
    const url = '${Constance.baseUrl}athckar.json';

    try {
      final response = await http.get(Uri.parse(url));

      if (response.statusCode == 200) {
        final List<dynamic> decodedList = json.decode(response.body);

        final athckars =
            decodedList.map((item) => Athckar.fromJson(item)).toList();

        return Success(athckars);
      } else {
        return Failed('Download failed: ${response.statusCode}');
      }
    } catch (e) {
      return Failed(e.toString());
    }
  }

  static Future<Result<List<Stories>>> loadStoriesData() async {
    const url = '${Constance.baseUrl}stories.json';

    try {
      final response = await http.get(Uri.parse(url));

      if (response.statusCode == 200) {
        final List<dynamic> decodedList = json.decode(response.body);

        final stories =
            decodedList.map((item) => Stories.fromJson(item)).toList();

        return Success(stories);
      } else {
        return Failed('Download failed: ${response.statusCode}');
      }
    } catch (e) {
      return Failed(e.toString());
    }
  }
}

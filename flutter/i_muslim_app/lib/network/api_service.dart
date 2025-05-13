import 'package:i_muslim_app/models/Stoies.dart';
import 'package:i_muslim_app/ui/widget/custom_loading_widget.dart';

import '../models/Athckar.dart';
import '../models/Result.dart';
import 'build_http.dart';

class ApiService {
  Future<List<Athckar>> fetchAthckarData() async {
    try {
      Result<List<Athckar>> result = await HttpData.loadAthckarData();

      switch (result) {
        case Loading():
          print("Athckar Loading...");
          return [];

        case Success<List<Athckar>> success:
          final data = success.data;
          print("Success ${data.length} Athckar");
          return data;

        case Failed(:final message):
          print("Failed: $message");
          return [];
      }
    } catch (e) {
      print("Error: $e");
      return [];
    }
  }

  Future<List<Stories>> fetchStoriesData() async {
    try {
      Result<List<Stories>> result = await HttpData.loadStoriesData();

      switch (result) {
        case Loading():
          print("Stories Loading...");
          return [];

        case Success<List<Stories>> success:
          final data = success.data;
          print("Success ${data.length} Stories");
          return data;

        case Failed(:final message):
          print("Failed: $message");
          return [];
      }
    } catch (e) {
      print("Error: $e");
      return [];
    }
  }
}

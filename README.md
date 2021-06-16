# FetchExercise
A simple android application for parsing the [JSON file](https://fetch-hiring.s3.amazonaws.com/hiring.json) and processing its data.  
  It displays this list of items to the user based on the following requirements:

- All the items grouped by "listId"
- Sorted results first by "listId" then by "name" when displaying.
- Filtered out any items where "name" is blank or null.
## App Walkthrough
### Processed-raw data
<img src="https://github.com/Kidrah31/FetchExercise/blob/main/Raw_Data.gif" width=300><br>
 ### Group & Sort Implementation
 <img src="https://github.com/Kidrah31/FetchExercise/blob/main/Grouped_Sorted_Data.gif" width=300><br>
 ## Final list with filtered data
 <img src="https://github.com/Kidrah31/FetchExercise/blob/main/Final_Grouped_Sorted_Filtered.gif" width=300><br>
## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing

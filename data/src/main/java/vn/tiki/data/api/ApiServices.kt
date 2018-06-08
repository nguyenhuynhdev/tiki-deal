package vn.tiki.data.api

import android.content.Context
import android.os.Looper
import android.os.NetworkOnMainThreadException
import android.os.SystemClock
import android.support.annotation.WorkerThread
import org.json.JSONArray
import vn.tiki.data.entity.DealEntity
import vn.tiki.data.util.readFile
import java.util.Calendar
import javax.inject.Inject

class ApiServices @Inject constructor(private val context: Context) {
  companion object {
    const val INCREASING_SECONDS = 15
    const val DURATION = 60 // 1 minute
      const val ASSERT_FILE_PATTERN = "file:///android_asset"
  }

  @WorkerThread
  fun getDeals(): MutableList<DealEntity> {

    // Verify this is called on Worker Thread
    assertWorkerThread()

    // mock a delay
    SystemClock.sleep(500)

    val json = context.assets.readFile("data/deals.json")
    return JSONArray(json)
        .asSequence()
        .mapIndexed { index, jsonObject ->
          val name = jsonObject.getString("name")
          val price = jsonObject.getDouble("price")
          val thumbnail = "$ASSERT_FILE_PATTERN/data/images/${jsonObject.getString("thumbnail")}"
          val now = Calendar.getInstance()

          val startedDate = now
              .apply {
                add(Calendar.SECOND, index * INCREASING_SECONDS)
              }
              .time

          val endDate = now
              .apply {
                add(Calendar.SECOND, DURATION)
              }
              .time

            DealEntity(
              name,
              thumbnail,
              price,
              startedDate,
              endDate
          )
        }
        .toMutableList()
  }

  private fun assertWorkerThread() {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw NetworkOnMainThreadException()
    }
  }
}

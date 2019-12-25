
package yaniv.k.youtubeplaylist.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
// Video class
public class Item_ implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("snippet")
     private Snippet snippet;

    public Item_(String id) {
        this.id = id;
    }

    private Item_(Parcel in) {
        id = in.readString();
    }

    public static final Creator<Item_> CREATOR = new Creator<Item_>() {
        @Override
        public Item_ createFromParcel(Parcel in) {
            return new Item_(in);
        }

        @Override
        public Item_[] newArray(int size) {
            return new Item_[size];
        }
    };

    public String getId() {
        return id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
    }
}

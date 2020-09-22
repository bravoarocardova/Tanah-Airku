package com.bac.tanahairku;

import android.os.Parcel;
import android.os.Parcelable;

public class Provinsi implements Parcelable {
    private String name;
    private String ibukota;
    private String description;
    private String lambang;
    private String wilayah;

    Provinsi() {
    }

    private Provinsi(Parcel in) {
        name = in.readString();
        ibukota = in.readString();
        description = in.readString();
        lambang = in.readString();
        wilayah = in.readString();
    }

    public static final Creator<Provinsi> CREATOR = new Creator<Provinsi>() {
        @Override
        public Provinsi createFromParcel(Parcel in) {
            return new Provinsi(in);
        }

        @Override
        public Provinsi[] newArray(int size) {
            return new Provinsi[size];
        }
    };

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getIbukota() {
        return ibukota;
    }

    void setIbukota(String ibukota) {
        this.ibukota = ibukota;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getLambang() {
        return lambang;
    }

    void setLambang(String lambang) {
        this.lambang = lambang;
    }

    String getWilayah() {
        return wilayah;
    }

    void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(ibukota);
        dest.writeString(description);
        dest.writeString(lambang);
        dest.writeString(wilayah);
    }
}

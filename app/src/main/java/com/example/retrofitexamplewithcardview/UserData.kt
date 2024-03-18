package com.example.retrofitexamplewithcardview

import com.google.gson.annotations.SerializedName

data class UserData(
        val results: List<User>
)

data class User(
        val gender: String,
        val name: Names,
        val email: String,
        // If you want to give a different variable name (different than what is in the received data),
        // you need to use @SerializedName, otherwise you can simply give the same variable name
        @SerializedName("picture") val imageUrl: Picture
)

data class Names(
        val title: String,
        val first: String,
        val last: String
)

data class Picture(
        val medium: String
)


// Copied and pasted a sample response below to make it easier to write data class above
/*
{
        "results": [
        {
                "gender": "male",
                "name": {
                "title": "mr",
                "first": "brad",
                "last": "gibson"
        },
                "location": {
                "street": "9278 new road",
                "city": "kilcoole",
                "state": "waterford",
                "postcode": "93027",
                "coordinates": {
                "latitude": "20.9267",
                "longitude": "-7.9310"
        },
                "timezone": {
                "offset": "-3:30",
                "description": "Newfoundland"
        }
        },
                "email": "brad.gibson@example.com",
                "login": {
                "uuid": "155e77ee-ba6d-486f-95ce-0e0c0fb4b919",
                "username": "silverswan131",
                "password": "firewall",
                "salt": "TQA1Gz7x",
                "md5": "dc523cb313b63dfe5be2140b0c05b3bc",
                "sha1": "7a4aa07d1bedcc6bcf4b7f8856643492c191540d",
                "sha256": "74364e96174afa7d17ee52dd2c9c7a4651fe1254f471a78bda0190135dcd3480"
        },
                "dob": {
                "date": "1993-07-20T09:44:18.674Z",
                "age": 26
        },
                "registered": {
                "date": "2002-05-21T10:59:49.966Z",
                "age": 17
        },
                "phone": "011-962-7516",
                "cell": "081-454-0666",
                "id": {
                "name": "PPS",
                "value": "0390511T"
        },
                "picture": {
                "large": "https://randomuser.me/api/portraits/men/75.jpg",
                "medium": "https://randomuser.me/api/portraits/med/men/75.jpg",
                "thumbnail": "https://randomuser.me/api/portraits/thumb/men/75.jpg"
        },
                "nat": "IE"
        }
        ],
        "info": {
        "seed": "fea8be3e64777240",
        "results": 1,
        "page": 1,
        "version": "1.3"
        }
}

*/





// Copied and pasted a sample response below to make it easier to write data class above

/*
// Multiple  users
{"results":[
    {
        "gender":"female", "name":{ "title":"Mrs", "first":"Ella", "last":"Christiansen" }, "location":{ "street":{ "number":2531, "name":"Bygaden" }, "city":"Odense Sv", "state":"Danmark", "country":"Denmark", "postcode":83726, "coordinates":{ "latitude":"-34.9223", "longitude":"90.4579" }, "timezone":{ "offset":"+9:00", "description":"Tokyo, Seoul, Osaka, Sapporo, Yakutsk" } }, "email":"ella.christiansen@example.com", "login":{ "uuid":"316e4190-d555-42b3-8fe2-b65aa6abf5b4", "username":"blackpanda486", "password":"trombone", "salt":"xuuiRpr7", "md5":"36cbd5018196f9f01634fedb886ecd35", "sha1":"7b5005a991ddef5e0b4570d09d32d869c7063e3d", "sha256":"d21771f54d88628b7639c678c1bd1ac394fb363e7d33719979c837100933b01c" }, "dob":{ "date":"1963-05-07T19:51:03.373Z", "age":58 }, "registered":{ "date":"2013-04-18T00:38:04.993Z", "age":8 }, "phone":"46793728", "cell":"45326483", "id":{ "name":"CPR", "value":"070563-5040" }, "picture":{ "large":"https://randomuser.me/api/portraits/women/64.jpg", "medium":"https://randomuser.me/api/portraits/med/women/64.jpg", "thumbnail":"https://randomuser.me/api/portraits/thumb/women/64.jpg" }, "nat":"DK"
    },
    {
        "gender":"male", "name":{ "title":"Mr", "first":"Énio", "last":"Mendes" }, "location":{ "street":{ "number":4795, "name":"Rua São Francisco " }, "city":"Queimados", "state":"Acre", "country":"Brazil", "postcode":44728, "coordinates":{ "latitude":"68.9388", "longitude":"-29.0877" }, "timezone":{ "offset":"+5:45", "description":"Kathmandu" } }, "email":"enio.mendes@example.com", "login":{ "uuid":"853a6d58-0711-47f9-87bb-06c6d1ce5fb1", "username":"bigelephant325", "password":"pizzas", "salt":"UyZhU3v8", "md5":"d3567d28635b70538b051cf3192b1781", "sha1":"308dafd064c7de775d6e72a907a8ac6ef117ed33", "sha256":"8709ef9aa2b99bcdc4cb84c6bda8af673aeee75ac915b484435912f290ec958f" }, "dob":{ "date":"1947-06-13T19:43:42.554Z", "age":74 }, "registered":{ "date":"2018-04-19T08:34:40.713Z", "age":3 }, "phone":"(08) 2691-0945", "cell":"(15) 7371-3240", "id":{ "name":"", "value":null }, "picture":{ "large":"https://randomuser.me/api/portraits/men/99.jpg", "medium":"https://randomuser.me/api/portraits/med/men/99.jpg", "thumbnail":"https://randomuser.me/api/portraits/thumb/men/99.jpg" }, "nat":"BR"
    }]
    ,"info":
    { "seed":"03a36b6c3de58920", "results":2, "page":1, "version":"1.3" }
}
*/



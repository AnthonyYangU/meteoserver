@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
@insert("insert into humitemps(time,imeiId,airportCode,version,sequenceNumber,messageTime,messageType,sensorId,locationId,tains,tdins,rhins,vpins,ta10m,ta1x,ta1ha,ta1hx) values(#{humitemp.time},#{humitemp.imeiId},#{humitemp.airportCode},#{humitemp.version},#{humitemp.sequenceNumber},#{humitemp.messageTime},#{humitemp.messageType},#{humitemp.sensorId},#{humitemp.locationId},#{humitemp.tains},#{humitemp.tdins},#{humitemp.rhins},#{humitemp.vpins},#{humitemp.ta10m},#{humitemp.ta1x},#{humitemp.ta1ha},#{humitemp.ta1hx}))
void insert(@Param("humitemp") Humitemp humitemp);

@select("select * from humitemps where id=#{id}")
Humitemp getById(@Param("id") Long id);

@Select("select * from humitemps where airportName=#{airportName}")
)Humitemp getByAirportName(@Param("airportName") String airportName);
)
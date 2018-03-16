package com.dao.redisCache;

import com.util.util.SerializeUtil;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.*;
import redis.clients.util.Pool;
import redis.clients.util.Slowlog;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jiangjinhong on 17/10/29.
 */
public class JedisWrapper extends Jedis implements AutoCloseable {

    private Jedis jedis;

    public JedisWrapper(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public Long append(String key, String value) {
        return jedis.append(key, value);
    }

    @Override
    public String asking() {
        return jedis.asking();
    }

    @Override
    public Long bitcount(String key) {
        return jedis.bitcount(key);
    }

    @Override
    public Long bitcount(String key, long start, long end) {
        return jedis.bitcount(key, start, end);
    }

    @Override
    public Long bitop(BitOP op, String destKey, String... srcKeys) {
        return jedis.bitop(op, destKey, srcKeys);
    }

    @Override
    public Long bitpos(String key, boolean value) {
        return jedis.bitpos(key, value);
    }

    @Override
    public Long bitpos(String key, boolean value, BitPosParams params) {
        return jedis.bitpos(key, value, params);
    }

    @Override
    public List<String> blpop(String arg) {
        return jedis.blpop(arg);
    }

    @Override
    public List<String> blpop(String... args) {
        return jedis.blpop(args);
    }

    @Override
    public List<String> blpop(int timeout, String key) {
        return jedis.blpop(timeout, key);
    }

    @Override
    public List<String> blpop(int timeout, String... keys) {
        return jedis.blpop(timeout, keys);
    }

    @Override
    public List<String> brpop(String arg) {
        return jedis.brpop(arg);
    }

    @Override
    public List<String> brpop(String... args) {
        return jedis.brpop(args);
    }

    @Override
    public List<String> brpop(int timeout, String key) {
        return jedis.brpop(timeout, key);
    }

    @Override
    public List<String> brpop(int timeout, String... keys) {
        return jedis.brpop(timeout, keys);
    }

    @Override
    public String brpoplpush(String source, String destination, int timeout) {
        return jedis.brpoplpush(source, destination, timeout);
    }

    @Override
    public String clientKill(String client) {
        return jedis.clientKill(client);
    }

    @Override
    public String clientSetname(String name) {
        return jedis.clientSetname(name);
    }

    @Override
    public void close() {
        jedis.close();
    }

    @Override
    public String clusterAddSlots(int... slots) {
        return jedis.clusterAddSlots(slots);
    }

    @Override
    public Long clusterCountKeysInSlot(int slot) {
        return jedis.clusterCountKeysInSlot(slot);
    }

    @Override
    public String clusterDelSlots(int... slots) {
        return jedis.clusterDelSlots(slots);
    }

    @Override
    public String clusterFailover() {
        return jedis.clusterFailover();
    }

    @Override
    public String clusterFlushSlots() {
        return jedis.clusterFlushSlots();
    }

    @Override
    public String clusterForget(String nodeId) {
        return jedis.clusterForget(nodeId);
    }

    @Override
    public List<String> clusterGetKeysInSlot(int slot, int count) {
        return jedis.clusterGetKeysInSlot(slot, count);
    }

    @Override
    public String clusterInfo() {
        return jedis.clusterInfo();
    }

    @Override
    public Long clusterKeySlot(String key) {
        return jedis.clusterKeySlot(key);
    }

    @Override
    public String clusterMeet(String ip, int port) {
        return jedis.clusterMeet(ip, port);
    }

    @Override
    public String clusterNodes() {
        return jedis.clusterNodes();
    }

    @Override
    public String clusterReplicate(String nodeId) {
        return jedis.clusterReplicate(nodeId);
    }

    @Override
    public String clusterReset(JedisCluster.Reset resetType) {
        return jedis.clusterReset(resetType);
    }

    @Override
    public String clusterSaveConfig() {
        return jedis.clusterSaveConfig();
    }

    @Override
    public String clusterSetSlotImporting(int slot, String nodeId) {
        return jedis.clusterSetSlotImporting(slot, nodeId);
    }

    @Override
    public String clusterSetSlotMigrating(int slot, String nodeId) {
        return jedis.clusterSetSlotMigrating(slot, nodeId);
    }

    @Override
    public String clusterSetSlotNode(int slot, String nodeId) {
        return jedis.clusterSetSlotNode(slot, nodeId);
    }

    @Override
    public String clusterSetSlotStable(int slot) {
        return jedis.clusterSetSlotStable(slot);
    }

    @Override
    public List<String> clusterSlaves(String nodeId) {
        return jedis.clusterSlaves(nodeId);
    }

    @Override
    public List<Object> clusterSlots() {
        return jedis.clusterSlots();
    }

    @Override
    public List<String> configGet(String pattern) {
        return jedis.configGet(pattern);
    }

    @Override
    public String configSet(String parameter, String value) {
        return jedis.configSet(parameter, value);
    }

    @Override
    public Long decr(String key) {
        return jedis.decr(key);
    }

    @Override
    public Long decrBy(String key, long integer) {
        return jedis.decrBy(key, integer);
    }

    @Override
    public Long del(String key) {
        return jedis.del(key);
    }

    @Override
    public Long del(String... keys) {
        return jedis.del(keys);
    }

    @Override
    public byte[] dump(String key) {
        return jedis.dump(key);
    }

    @Override
    public String echo(String string) {
        return jedis.echo(string);
    }

    @Override
    public Object eval(String script) {
        return jedis.eval(script);
    }

    @Override
    public Object eval(String script, int keyCount, String... params) {
        return jedis.eval(script, keyCount, params);
    }

    @Override
    public Object eval(String script, List<String> keys, List<String> args) {
        return jedis.eval(script, keys, args);
    }

    @Override
    public Object evalsha(String script) {
        return jedis.evalsha(script);
    }

    @Override
    public Object evalsha(String sha1, int keyCount, String... params) {
        return jedis.evalsha(sha1, keyCount, params);
    }

    @Override
    public Object evalsha(String sha1, List<String> keys, List<String> args) {
        return jedis.evalsha(sha1, keys, args);
    }

    @Override
    public Boolean exists(String key) {
        return jedis.exists(key);
    }

    @Override
    public Long expire(String key, int seconds) {
        return jedis.expire(key, seconds);
    }

    @Override
    public Long expireAt(String key, long unixTime) {
        return jedis.expireAt(key, unixTime);
    }

    @Override
    public String get(String key) {
        return jedis.get(key);
    }

    @Override
    public Boolean getbit(String key, long offset) {
        return jedis.getbit(key, offset);
    }

    @Override
    public String getrange(String key, long startOffset, long endOffset) {
        return jedis.getrange(key, startOffset, endOffset);
    }

    @Override
    public String getSet(String key, String value) {
        return jedis.getSet(key, value);
    }

    @Override
    public Long hdel(String key, String... fields) {
        return jedis.hdel(key, fields);
    }

    @Override
    public Boolean hexists(String key, String field) {
        return jedis.hexists(key, field);
    }

    @Override
    public String hget(String key, String field) {
        return jedis.hget(key, field);
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        return jedis.hgetAll(key);
    }

    @Override
    public Long hincrBy(String key, String field, long value) {
        return jedis.hincrBy(key, field, value);
    }

    @Override
    public Double hincrByFloat(String key, String field, double value) {
        return jedis.hincrByFloat(key, field, value);
    }

    @Override
    public Set<String> hkeys(String key) {
        return jedis.hkeys(key);
    }

    @Override
    public Long hlen(String key) {
        return jedis.hlen(key);
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        return jedis.hmget(key, fields);
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        return jedis.hmset(key, hash);
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, int cursor) {
        return jedis.hscan(key, cursor);
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, int cursor, ScanParams params) {
        return jedis.hscan(key, cursor, params);
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) {
        return jedis.hscan(key, cursor);
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams params) {
        return jedis.hscan(key, cursor, params);
    }

    @Override
    public Long hset(String key, String field, String value) {
        return jedis.hset(key, field, value);
    }

    @Override
    public Long hsetnx(String key, String field, String value) {
        return jedis.hsetnx(key, field, value);
    }

    @Override
    public List<String> hvals(String key) {
        return jedis.hvals(key);
    }

    @Override
    public Long incr(String key) {
        return jedis.incr(key);
    }

    @Override
    public Long incrBy(String key, long integer) {
        return jedis.incrBy(key, integer);
    }

    @Override
    public Double incrByFloat(String key, double value) {
        return jedis.incrByFloat(key, value);
    }

    @Override
    public Set<String> keys(String pattern) {
        return jedis.keys(pattern);
    }

    @Override
    public String lindex(String key, long index) {
        return jedis.lindex(key, index);
    }

    @Override
    public Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        return jedis.linsert(key, where, pivot, value);
    }

    @Override
    public Long llen(String key) {
        return jedis.llen(key);
    }

    @Override
    public String lpop(String key) {
        return jedis.lpop(key);
    }

    @Override
    public Long lpush(String key, String... strings) {
        return jedis.lpush(key, strings);
    }

    @Override
    public Long lpushx(String key, String... string) {
        return jedis.lpushx(key, string);
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        return jedis.lrange(key, start, end);
    }

    @Override
    public Long lrem(String key, long count, String value) {
        return jedis.lrem(key, count, value);
    }

    @Override
    public String lset(String key, long index, String value) {
        return jedis.lset(key, index, value);
    }

    @Override
    public String ltrim(String key, long start, long end) {
        return jedis.ltrim(key, start, end);
    }

    @Override
    public List<String> mget(String... keys) {
        return jedis.mget(keys);
    }

    @Override
    public String migrate(String host, int port, String key, int destinationDb, int timeout) {
        return jedis.migrate(host, port, key, destinationDb, timeout);
    }

    @Override
    public Long move(String key, int dbIndex) {
        return jedis.move(key, dbIndex);
    }

    @Override
    public String mset(String... keysvalues) {
        return jedis.mset(keysvalues);
    }

    @Override
    public Long msetnx(String... keysvalues) {
        return jedis.msetnx(keysvalues);
    }

    @Override
    public String objectEncoding(String string) {
        return jedis.objectEncoding(string);
    }

    @Override
    public Long objectIdletime(String string) {
        return jedis.objectIdletime(string);
    }

    @Override
    public Long objectRefcount(String string) {
        return jedis.objectRefcount(string);
    }

    @Override
    public Long persist(String key) {
        return jedis.persist(key);
    }

    @Override
    public Long pexpire(String key, int milliseconds) {
        return jedis.pexpire(key, milliseconds);
    }

    @Override
    public Long pexpire(String key, long milliseconds) {
        return jedis.pexpire(key, milliseconds);
    }

    @Override
    public Long pexpireAt(String key, long millisecondsTimestamp) {
        return jedis.pexpireAt(key, millisecondsTimestamp);
    }

    @Override
    public Long pfadd(String key, String... elements) {
        return jedis.pfadd(key, elements);
    }

    @Override
    public long pfcount(String key) {
        return jedis.pfcount(key);
    }

    @Override
    public long pfcount(String... keys) {
        return jedis.pfcount(keys);
    }

    @Override
    public String pfmerge(String destkey, String... sourcekeys) {
        return jedis.pfmerge(destkey, sourcekeys);
    }

    @Override
    public String psetex(String key, int milliseconds, String value) {
        return jedis.psetex(key, milliseconds, value);
    }

    @Override
    public String psetex(String key, long milliseconds, String value) {
        return jedis.psetex(key, milliseconds, value);
    }

    @Override
    public void psubscribe(JedisPubSub jedisPubSub, String... patterns) {
        jedis.psubscribe(jedisPubSub, patterns);
    }

    @Override
    public Long pttl(String key) {
        return jedis.pttl(key);
    }

    @Override
    public Long publish(String channel, String message) {
        return jedis.publish(channel, message);
    }

    @Override
    public List<String> pubsubChannels(String pattern) {
        return jedis.pubsubChannels(pattern);
    }

    @Override
    public Long pubsubNumPat() {
        return jedis.pubsubNumPat();
    }

    @Override
    public Map<String, String> pubsubNumSub(String... channels) {
        return jedis.pubsubNumSub(channels);
    }

    @Override
    public String randomKey() {
        return jedis.randomKey();
    }

    @Override
    public String rename(String oldkey, String newkey) {
        return jedis.rename(oldkey, newkey);
    }

    @Override
    public Long renamenx(String oldkey, String newkey) {
        return jedis.renamenx(oldkey, newkey);
    }

    @Override
    public String restore(String key, int ttl, byte[] serializedValue) {
        return jedis.restore(key, ttl, serializedValue);
    }

    @Override
    public String rpop(String key) {
        return jedis.rpop(key);
    }

    @Override
    public String rpoplpush(String srckey, String dstkey) {
        return jedis.rpoplpush(srckey, dstkey);
    }

    @Override
    public Long rpush(String key, String... strings) {
        return jedis.rpush(key, strings);
    }

    @Override
    public Long rpushx(String key, String... string) {
        return jedis.rpushx(key, string);
    }

    @Override
    public Long sadd(String key, String... members) {
        return jedis.sadd(key, members);
    }

    @Override
    public ScanResult<String> scan(int cursor) {
        return jedis.scan(cursor);
    }

    @Override
    public ScanResult<String> scan(int cursor, ScanParams params) {
        return jedis.scan(cursor, params);
    }

    @Override
    public ScanResult<String> scan(String cursor) {
        return jedis.scan(cursor);
    }

    @Override
    public ScanResult<String> scan(String cursor, ScanParams params) {
        return jedis.scan(cursor, params);
    }

    @Override
    public Long scard(String key) {
        return jedis.scard(key);
    }

    @Override
    public Boolean scriptExists(String sha1) {
        return jedis.scriptExists(sha1);
    }

    @Override
    public List<Boolean> scriptExists(String... sha1) {
        return jedis.scriptExists(sha1);
    }

    @Override
    public String scriptLoad(String script) {
        return jedis.scriptLoad(script);
    }

    @Override
    public Set<String> sdiff(String... keys) {
        return jedis.sdiff(keys);
    }

    @Override
    public Long sdiffstore(String dstkey, String... keys) {
        return jedis.sdiffstore(dstkey, keys);
    }

    @Override
    public String sentinelFailover(String masterName) {
        return jedis.sentinelFailover(masterName);
    }

    @Override
    public List<String> sentinelGetMasterAddrByName(String masterName) {
        return jedis.sentinelGetMasterAddrByName(masterName);
    }

    @Override
    public List<Map<String, String>> sentinelMasters() {
        return jedis.sentinelMasters();
    }

    @Override
    public String sentinelMonitor(String masterName, String ip, int port, int quorum) {
        return jedis.sentinelMonitor(masterName, ip, port, quorum);
    }

    @Override
    public String sentinelRemove(String masterName) {
        return jedis.sentinelRemove(masterName);
    }

    @Override
    public Long sentinelReset(String pattern) {
        return jedis.sentinelReset(pattern);
    }

    @Override
    public String sentinelSet(String masterName, Map<String, String> parameterMap) {
        return jedis.sentinelSet(masterName, parameterMap);
    }

    @Override
    public List<Map<String, String>> sentinelSlaves(String masterName) {
        return jedis.sentinelSlaves(masterName);
    }

    @Override
    public String set(String key, String value) {
        return jedis.set(key, value);
    }

    @Override
    public String set(String key, String value, String nxxx) {
        return jedis.set(key, value, nxxx);
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, int time) {
        return jedis.set(key, value, nxxx, expx, time);
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        return jedis.set(key, value, nxxx, expx, time);
    }

    @Override
    public Boolean setbit(String key, long offset, boolean value) {
        return jedis.setbit(key, offset, value);
    }

    @Override
    public Boolean setbit(String key, long offset, String value) {
        return jedis.setbit(key, offset, value);
    }

    @Override
    public void setDataSource(Pool<Jedis> jedisPool) {
        jedis.setDataSource(jedisPool);
    }

    @Override
    public String setex(String key, int seconds, String value) {
        return jedis.setex(key, seconds, value);
    }

    @Override
    public Long setnx(String key, String value) {
        return jedis.setnx(key, value);
    }

    @Override
    public Long setrange(String key, long offset, String value) {
        return jedis.setrange(key, offset, value);
    }

    @Override
    public Set<String> sinter(String... keys) {
        return jedis.sinter(keys);
    }

    @Override
    public Long sinterstore(String dstkey, String... keys) {
        return jedis.sinterstore(dstkey, keys);
    }

    @Override
    public Boolean sismember(String key, String member) {
        return jedis.sismember(key, member);
    }

    @Override
    public List<Slowlog> slowlogGet() {
        return jedis.slowlogGet();
    }

    @Override
    public List<Slowlog> slowlogGet(long entries) {
        return jedis.slowlogGet(entries);
    }

    @Override
    public Set<String> smembers(String key) {
        return jedis.smembers(key);
    }

    @Override
    public Long smove(String srckey, String dstkey, String member) {
        return jedis.smove(srckey, dstkey, member);
    }

    @Override
    public List<String> sort(String key) {
        return jedis.sort(key);
    }

    @Override
    public Long sort(String key, String dstkey) {
        return jedis.sort(key, dstkey);
    }

    @Override
    public List<String> sort(String key, SortingParams sortingParameters) {
        return jedis.sort(key, sortingParameters);
    }

    @Override
    public Long sort(String key, SortingParams sortingParameters, String dstkey) {
        return jedis.sort(key, sortingParameters, dstkey);
    }

    @Override
    public String spop(String key) {
        return jedis.spop(key);
    }

    @Override
    public Set<String> spop(String key, long count) {
        return jedis.spop(key, count);
    }

    @Override
    public String srandmember(String key) {
        return jedis.srandmember(key);
    }

    @Override
    public List<String> srandmember(String key, int count) {
        return jedis.srandmember(key, count);
    }

    @Override
    public Long srem(String key, String... members) {
        return jedis.srem(key, members);
    }

    @Override
    public ScanResult<String> sscan(String key, int cursor) {
        return jedis.sscan(key, cursor);
    }

    @Override
    public ScanResult<String> sscan(String key, int cursor, ScanParams params) {
        return jedis.sscan(key, cursor, params);
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor) {
        return jedis.sscan(key, cursor);
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor, ScanParams params) {
        return jedis.sscan(key, cursor, params);
    }

    @Override
    public Long strlen(String key) {
        return jedis.strlen(key);
    }

    @Override
    public void subscribe(JedisPubSub jedisPubSub, String... channels) {
        jedis.subscribe(jedisPubSub, channels);
    }

    @Override
    public String substr(String key, int start, int end) {
        return jedis.substr(key, start, end);
    }

    @Override
    public Set<String> sunion(String... keys) {
        return jedis.sunion(keys);
    }

    @Override
    public Long sunionstore(String dstkey, String... keys) {
        return jedis.sunionstore(dstkey, keys);
    }

    @Override
    public Long ttl(String key) {
        return jedis.ttl(key);
    }

    @Override
    public String type(String key) {
        return jedis.type(key);
    }

    @Override
    public String watch(String... keys) {
        return jedis.watch(keys);
    }

    @Override
    public Long zadd(String key, double score, String member) {
        return jedis.zadd(key, score, member);
    }

    @Override
    public Long zadd(String key, Map<String, Double> scoreMembers) {
        return jedis.zadd(key, scoreMembers);
    }

    @Override
    public Long zcard(String key) {
        return jedis.zcard(key);
    }

    @Override
    public Long zcount(String key, double min, double max) {
        return jedis.zcount(key, min, max);
    }

    @Override
    public Long zcount(String key, String min, String max) {
        return jedis.zcount(key, min, max);
    }

    @Override
    public Double zincrby(String key, double score, String member) {
        return jedis.zincrby(key, score, member);
    }

    @Override
    public Long zinterstore(String dstkey, ZParams params, String... sets) {
        return jedis.zinterstore(dstkey, params, sets);
    }

    @Override
    public Long zinterstore(String dstkey, String... sets) {
        return jedis.zinterstore(dstkey, sets);
    }

    @Override
    public Long zlexcount(String key, String min, String max) {
        return jedis.zlexcount(key, min, max);
    }

    @Override
    public Set<String> zrange(String key, long start, long end) {
        return jedis.zrange(key, start, end);
    }

    @Override
    public Set<String> zrangeByLex(String key, String min, String max) {
        return jedis.zrangeByLex(key, min, max);
    }

    @Override
    public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
        return jedis.zrangeByLex(key, min, max, offset, count);
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max) {
        return jedis.zrangeByScore(key, min, max);
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        return jedis.zrangeByScore(key, min, max, offset, count);
    }

    @Override
    public Set<String> zrangeByScore(String key, String min, String max) {
        return jedis.zrangeByScore(key, min, max);
    }

    @Override
    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
        return jedis.zrangeByScore(key, min, max, offset, count);
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
        return jedis.zrangeByScoreWithScores(key, min, max);
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        return jedis.zrangeByScoreWithScores(key, min, max, offset, count);
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
        return jedis.zrangeByScoreWithScores(key, min, max);
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
        return jedis.zrangeByScoreWithScores(key, min, max, offset, count);
    }

    @Override
    public Set<Tuple> zrangeWithScores(String key, long start, long end) {
        return jedis.zrangeWithScores(key, start, end);
    }

    @Override
    public Long zrank(String key, String member) {
        return jedis.zrank(key, member);
    }

    @Override
    public Long zrem(String key, String... members) {
        return jedis.zrem(key, members);
    }

    @Override
    public Long zremrangeByLex(String key, String min, String max) {
        return jedis.zremrangeByLex(key, min, max);
    }

    @Override
    public Long zremrangeByRank(String key, long start, long end) {
        return jedis.zremrangeByRank(key, start, end);
    }

    @Override
    public Long zremrangeByScore(String key, double start, double end) {
        return jedis.zremrangeByScore(key, start, end);
    }

    @Override
    public Long zremrangeByScore(String key, String start, String end) {
        return jedis.zremrangeByScore(key, start, end);
    }

    @Override
    public Set<String> zrevrange(String key, long start, long end) {
        return jedis.zrevrange(key, start, end);
    }

    @Override
    public Set<String> zrevrangeByLex(String key, String max, String min) {
        return jedis.zrevrangeByLex(key, max, min);
    }

    @Override
    public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
        return jedis.zrevrangeByLex(key, max, min, offset, count);
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min) {
        return jedis.zrevrangeByScore(key, max, min);
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        return jedis.zrevrangeByScore(key, max, min, offset, count);
    }

    @Override
    public Set<String> zrevrangeByScore(String key, String max, String min) {
        return jedis.zrevrangeByScore(key, max, min);
    }

    @Override
    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {
        return jedis.zrevrangeByScore(key, max, min, offset, count);
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
        return jedis.zrevrangeByScoreWithScores(key, max, min);
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
        return jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {
        return jedis.zrevrangeByScoreWithScores(key, max, min);
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count) {
        return jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
    }

    @Override
    public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        return jedis.zrevrangeWithScores(key, start, end);
    }

    @Override
    public Long zrevrank(String key, String member) {
        return jedis.zrevrank(key, member);
    }

    @Override
    public ScanResult<Tuple> zscan(String key, int cursor) {
        return jedis.zscan(key, cursor);
    }

    @Override
    public ScanResult<Tuple> zscan(String key, int cursor, ScanParams params) {
        return jedis.zscan(key, cursor, params);
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor) {
        return jedis.zscan(key, cursor);
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
        return jedis.zscan(key, cursor, params);
    }

    @Override
    public Double zscore(String key, String member) {
        return jedis.zscore(key, member);
    }

    @Override
    public Long zunionstore(String dstkey, ZParams params, String... sets) {
        return jedis.zunionstore(dstkey, params, sets);
    }

    @Override
    public Long zunionstore(String dstkey, String... sets) {
        return jedis.zunionstore(dstkey, sets);
    }

    public String setex(String key, int expiredSeconds, Object object) {
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("key can not null");
        }
        return jedis.setex(key.getBytes(), expiredSeconds, SerializeUtil.serialize(object));
    }

    public <T> T getObject(String key) {
        if (StringUtils.isBlank(key)) {
            throw new RuntimeException("key can not null");
        }

        Object object = SerializeUtil.unserialize(jedis.get(key.getBytes()));
        if (null == object) {
            return null;
        }

        return (T) object;
    }

    public Jedis getJedis() {
        return this.jedis;
    }

}

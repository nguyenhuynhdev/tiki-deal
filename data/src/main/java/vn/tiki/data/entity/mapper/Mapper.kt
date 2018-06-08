package vn.tiki.data.entity.mapper

interface Mapper<T, V> {

    fun transformTo(obj: T): V

    fun transformTo(listObj: MutableList<T>): MutableList<V>

}
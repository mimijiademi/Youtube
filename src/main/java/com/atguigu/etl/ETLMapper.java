package com.atguigu.etl;

import com.atguigu.util.ETLUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by Administrator on 2018/5/21.
 */
public class ETLMapper extends Mapper<LongWritable,Text,NullWritable,Text> {
    private Text v = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String etlString = ETLUtil.ETLString(value.toString());
        
        if (StringUtils.isBlank(etlString)) return;

        v.set(etlString);
        context.write(NullWritable.get(),v);
    }
}

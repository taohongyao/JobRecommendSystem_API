package link.imcloud.jrs.resume.process;

/*import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentencePreProcessor;*/

import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by 44247 on 2017/3/22 0022.
 */

public class GenerateWordVec {

/*

    @Test
    public void NLPWordVecTest () throws Exception {
        Word2Vec vec = WordVectorSerializer.readWord2VecModel(new File("D:\\study\\project\\Competetion\\职位推荐系统\\pathToSaveModel.txt"));
        Collection<String> kingList = vec.wordsNearest(Arrays.asList("小米", "百度"), Arrays.asList("手机"), 10);
        System.out.println(kingList);
        Collection<String> kingList2 =vec.wordsNearest("程序员",40);
                System.out.println(kingList2);
    }
*/

    public  void cerateWordVec(File words,String vectPath) throws IOException {
/*
        // Strip white space before and after for each line
        SentenceIterator iter = new BasicLineIterator(words);
        iter.setPreProcessor(new SentencePreProcessor() {
            @Override
            public String preProcess(String sentence) {
                return sentence.toLowerCase();
            }
        });

        // Split on white spaces in the line to get words

        Word2Vec vec = new Word2Vec.Builder()
                .minWordFrequency(5)
                .iterations(1)
                .layerSize(100)
                .seed(42)
                .windowSize(5)
                .iterate(iter)
                .build();

        vec.fit();

        // Write word vectors
//        WordVectorSerializer.writeWordVectors(vec, vectPath); //生产词向量txt
        WordVectorSerializer.writeWord2VecModel(vec, vectPath); //生产word2vec模型 ，方便以后加载
*/
    }
}

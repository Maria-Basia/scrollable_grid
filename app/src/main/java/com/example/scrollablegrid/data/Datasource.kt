package com.example.scrollablegrid.data
import com.example.scrollablegrid.R
import com.example.scrollablegrid.model.Topic

class Datasource() {
    fun loadTopics(): List<Topic> {
        return listOf<Topic>(
            Topic(R.drawable.architecture, R.string.architecture, 58),
            Topic(R.drawable.automotive, R.string.automotive, 38),
            Topic(R.drawable.biology, R.string.biology, 58),
            Topic(R.drawable.business, R.string.business, 40),
            Topic(R.drawable.crafts, R.string.crafts, 67),
            Topic(R.drawable.culinary, R.string.culinary, 89),
            Topic(R.drawable.design, R.string.design, 12),
            Topic(R.drawable.drawing, R.string.drawing, 23),
            Topic(R.drawable.ecology, R.string.ecology, 45),
            Topic(R.drawable.engineering, R.string.engineering, 46),
            Topic(R.drawable.fashion, R.string.fashion, 87),
            Topic(R.drawable.film, R.string.film, 75),
            Topic(R.drawable.finance, R.string.finance, 65),
            Topic(R.drawable.gaming, R.string.gaming, 53),
            Topic(R.drawable.geology, R.string.geology, 89),
            Topic(R.drawable.history, R.string.history, 43),
            Topic(R.drawable.journalism, R.string.journalism, 23),
            Topic(R.drawable.law, R.string.law, 32),
            Topic(R.drawable.lifestyle, R.string.lidestyle, 13),
            Topic(R.drawable.music, R.string.music, 87),
            Topic(R.drawable.painting, R.string.painting, 80),
            Topic(R.drawable.photography, R.string.photography, 34),
            Topic(R.drawable.physics, R.string.physics, 12),
            Topic(R.drawable.tech, R.string.tech, 150)
        )
    }
}
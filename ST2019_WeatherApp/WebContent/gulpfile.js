var gulp = require('gulp');
var sass = require('gulp-sass');
var sourcemaps = require("gulp-sourcemaps");
var autoprefixer = require('gulp-autoprefixer');
var concat = require("gulp-concat");

gulp.task('watch', function () {
    return gulp.watch('styles/**/*.scss', gulp.series('scss'));
});

gulp.task('scss', function () {
    return gulp.src('styles/**/*.scss')
    .pipe(sourcemaps.init())
    .pipe(sass().on('error', sass.logError))
    .pipe(autoprefixer())
    .pipe(concat('app.css'))
    .pipe(sourcemaps.write())
    .pipe(gulp.dest('styles/dist'));
});